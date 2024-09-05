package com.project.orderService.service;

import java.util.List;

import com.project.orderService.DTO.OrderRequest;
import com.project.orderService.DTO.OrderResponse;
import com.project.orderService.DTO.OrderlineResponse;

import jakarta.validation.Valid;

public interface OrderService {


//	void placeOrderCheck(OrderRequest orderRequestList);

	Integer createOrder(@Valid OrderRequest request);

	List<OrderResponse> findAllOrders();

	OrderResponse findById(Integer orderId);

	List<OrderlineResponse> findAllByOrderId(Integer orderId);

}
