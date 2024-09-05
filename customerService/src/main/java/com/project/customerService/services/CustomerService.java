package com.project.customerService.services;


	
	import org.apache.commons.lang.StringUtils;
	import org.springframework.stereotype.Service;

import com.project.customerService.DTOs.CustomerMapper;
import com.project.customerService.DTOs.CustomerRequest;
import com.project.customerService.DTOs.CustomerResponse;
import com.project.customerService.exceptions.CustomerNotFoundException;
import com.project.customerService.model.Customer;

import java.util.List;
	import java.util.stream.Collectors;

	@Service
	public class CustomerService {

	  private final CustomerRepository repository;
	  private final CustomerMapper mapper;
	  
	  

	  public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	public String createCustomer(CustomerRequest request) {
	    var customer = this.repository.save(mapper.toCustomer(request));
	    return customer.getId();
	  }

	  public void updateCustomer(CustomerRequest request) {
	    var customer = this.repository.findById(request.id())
	        .orElseThrow(() -> new CustomerNotFoundException(
	            String.format("Cannot update customer:: No customer found with the provided ID: %s", request.id())
	        ));
	    mergeCustomer(customer, request);
	    this.repository.save(customer);
	  }

	  private void mergeCustomer(Customer customer, CustomerRequest request) {
	    if (StringUtils.isNotBlank(request.firstname())) {
	      customer.setFirstname(request.firstname());
	    }
	    if (StringUtils.isNotBlank(request.email())) {
	      customer.setEmail(request.email());
	    }
	    if (request.address() != null) {
	      customer.setAddress(request.address());
	    }
	  }

	  public List<CustomerResponse> findAllCustomers() {
	    return  this.repository.findAll()
	        .stream()
	        .map(this.mapper::fromCustomer)
	        .collect(Collectors.toList());
	  }

	  public CustomerResponse findById(String id) {
	    return this.repository.findById(id)
	        .map(mapper::fromCustomer)
	        .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with the provided ID: %s", id)));
	  }

	  public boolean existsById(String id) {
	    return this.repository.findById(id)
	        .isPresent();
	  }

	  public void deleteCustomer(String id) {
	    this.repository.deleteById(id);
	  }
	}
