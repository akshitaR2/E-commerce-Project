package com.project.orderService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.orderService.DTO.OrderRequest;
import com.project.orderService.DTO.OrderResponse;
import com.project.orderService.DTO.OrderlineResponse;
import com.project.orderService.DTO.PurchaseRequest;
import com.project.orderService.client.CustomerClient;
import com.project.orderService.client.PaymentClient;
import com.project.orderService.ClientResponse.CustomerResponse;
import com.project.orderService.ClientResponse.PaymentRequest;
import com.project.orderService.ClientResponse.PurchaseResponse;
import com.project.orderService.client.ProductClient;
import com.project.orderService.exception.CustomerNotFoundException;
import com.project.orderService.kafka.OrderConfirmation;
import com.project.orderService.kafka.OrderProducer;
import com.project.orderService.model.OrderLine;
import com.project.orderService.model.OrderMapper;
import com.project.orderService.repository.OrderRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class OrderServiceImpl implements OrderService{
	
	private static final Logger logger=LoggerFactory.getLogger(OrderService.class);
	
	private final OrderLineServiceImpl orderLineService;
	private final OrderRepo repo;
	private final OrderMapper mapper;
	private final CustomerClient customerClient;
	private final ProductClient productClient;
	private final OrderProducer orderProducer;
	private final PaymentClient paymentClient;

	

	public OrderServiceImpl(OrderLineServiceImpl orderLineService, OrderRepo repo, OrderMapper mapper,
			CustomerClient customerClient, ProductClient productClient, OrderProducer orderProducer,PaymentClient paymentClient) {
		super();
		this.orderLineService = orderLineService;
		this.repo = repo;
		this.mapper = mapper;
		this.customerClient = customerClient;
		this.productClient = productClient;
		this.orderProducer = orderProducer;
		this.paymentClient=paymentClient;
	}

	@Override
	@Transactional
	public Integer createOrder(@Valid OrderRequest request) {
		try {
//            check the customer
	var customer =this.customerClient.findCustomerById(request.customerId()).orElseThrow(()->
						new CustomerNotFoundException("Customer details are incorrect :: customer id is blocked or deleted"));
		
//              purchase the products
	var products= this.productClient.purchaseProducts(request.products());
		
//              persist order
		var order=this.repo.save(mapper.toOrder(request));
		
//		        persist order line 
		request.products().forEach(product->{
			orderLineService.saveOderLine(order,product.productId(),product.quantity());
		});
		
//              start payment process
		 var paymentRequest = new PaymentRequest(
	                request.amount(),
	                request.paymentMethod(),
	                order.getId(),
	                order.getReference(),
	                customer
	        );
		 this.paymentClient.createPayment(paymentRequest);
//                send the notification
		orderProducer.sendOrderConfirmation(new OrderConfirmation(
				order.getReference(),
				order.getTotalAmount(),
				order.getPaymentMethod()
				,customer, 
				products));
		
		return order.getId();
		}catch (Exception e) {
			compensateOrder(request.products());
			throw e;
		}
	}


	@Override
	public List<OrderResponse> findAllOrders() {
		 return this.repo.findAll()
	                .stream()
	                .map(this.mapper::fromOrder)
	                .collect(Collectors.toList());
	}

	@Override
	public OrderResponse findById(Integer orderId) {
		 return this.repo.findById(orderId)
	                .map(this.mapper::fromOrder)
	                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", orderId)));
	    }

	  public List<OrderlineResponse> findAllByOrderId(Integer orderId) {
	        return orderLineService.findAllByOrderId(orderId);
	               
	    }
	  
	  private void compensateOrder(List<PurchaseRequest> request) {
	        logger.info("rollback is called for products");
	        this.productClient.rollbackProducts(request);
	    }

}
