package com.project.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.orderService.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
