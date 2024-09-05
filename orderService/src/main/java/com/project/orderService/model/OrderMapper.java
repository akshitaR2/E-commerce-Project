package com.project.orderService.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.orderService.DTO.OrderRequest;
import com.project.orderService.DTO.OrderResponse;

@Component
public class OrderMapper {
	
	public Order toOrder(OrderRequest request) {
	    if (request == null) {
	      return null;
	    }
	    return new Order( request.paymentMethod(),request.customerId());
	  }

	  public OrderResponse fromOrder(Order order) {
	    return new OrderResponse(
	        order.getId(),
	        order.getReference(),
	        order.getTotalAmount(),
	        order.getPaymentMethod(),
	        order.getCustomerId()
	    );
	  }
}
