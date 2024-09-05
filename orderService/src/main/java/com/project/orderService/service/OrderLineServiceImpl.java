package com.project.orderService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.orderService.DTO.OrderlineResponse;
import com.project.orderService.model.Order;
import com.project.orderService.model.OrderLine;
import com.project.orderService.repository.OrderLineRepo;

@Service
public class OrderLineServiceImpl {
	
	@Autowired
	private OrderLineRepo repo;
	
	@Transactional
	public Integer saveOderLine(Order order, String productId, double quantity) {
		return repo.save(new OrderLine(order, productId, quantity)).getId();
		
	}


	public List<OrderlineResponse> findAllByOrderId(Integer orderId) {
		return repo.findAllByOrderId(orderId)
        .stream().map(orderLine->toOrderLineResponse(orderLine)).toList();
	}

	private OrderlineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderlineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }

}
