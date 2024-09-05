package com.project.customerService.DTOs;

import org.springframework.stereotype.Component;

import com.project.customerService.model.Customer;

@Component
public class CustomerMapper {

  public Customer toCustomer(CustomerRequest request) {
    if (request == null) {
      return null;
    }
    return new Customer(
        request.id(),
        request.firstname(),
        request.lastname(),
        request.email(),
        request.address());
       
  }

  public CustomerResponse fromCustomer(Customer customer) {
    if (customer == null) {
      return null;
    }
    return new CustomerResponse(
        customer.getId(),
        customer.getFirstname(),
        customer.getLastname(),
        customer.getEmail(),
        customer.getAddress()
    );
  }
}
