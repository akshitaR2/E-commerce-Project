package com.project.orderService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.orderService.model.OrderLine;

@Repository
public interface OrderLineRepo extends JpaRepository<OrderLine, Integer>{

	List<OrderLine> findAllByOrderId(Integer orderId);

}
