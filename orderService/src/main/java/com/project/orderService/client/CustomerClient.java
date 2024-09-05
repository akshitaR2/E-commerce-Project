package com.project.orderService.client;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import com.project.orderService.ClientResponse.CustomerResponse;


@FeignClient(
	    name = "customerService",
	    url = "${application.config.customer-url}"
	)
	public interface CustomerClient {

	  @GetMapping("/{customer-id}")
	  Optional<CustomerResponse> findCustomerById(@PathVariable("customer-id") String customerId);
	}
