package com.project.otherServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.otherServices.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
