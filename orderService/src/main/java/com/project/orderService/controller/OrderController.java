package com.project.orderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.orderService.DTO.OrderDTO;
import com.project.orderService.DTO.OrderRequest;
import com.project.orderService.DTO.OrderResponse;
import com.project.orderService.DTO.OrderlineResponse;
import com.project.orderService.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order/api")
public class OrderController {
	
	@Autowired
	OrderService service;

//	
//	 @PostMapping
//	    @ResponseStatus(code = HttpStatus.CREATED)
//	    public String placeOrdercheck(@RequestBody OrderRequest orderRequest) {
//	        service.placeOrderCheck(orderRequest);
//	        return "Order Placed Successfully";
//	    }
	
	 @PostMapping
	  public ResponseEntity<Integer> createOrder(
	      @RequestBody @Valid OrderRequest request
	  ) {
	    return ResponseEntity.ok(this.service.createOrder(request));
	  }

	  @GetMapping
	  public ResponseEntity<List<OrderResponse>> findAll() {
	    return ResponseEntity.ok(this.service.findAllOrders());
	  }
	

	  @GetMapping("/{order-id}")
	  public ResponseEntity<OrderResponse> findById(
	      @PathVariable("order-id") Integer orderId
	  ) {
	    return ResponseEntity.ok(this.service.findById(orderId));
	  }
	  
	  @GetMapping("/order/{order-id}")
	    public ResponseEntity<List<OrderlineResponse>> findByOrderId(
	            @PathVariable("order-id") Integer orderId
	    ) {
	        return ResponseEntity.ok(service.findAllByOrderId(orderId));
	    }
	
}
