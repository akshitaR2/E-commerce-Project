package com.project.customerService.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.customerService.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

}
