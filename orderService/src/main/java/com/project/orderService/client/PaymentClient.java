package com.project.orderService.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.project.orderService.ClientResponse.PaymentRequest;

@FeignClient(
	    name = "paymentService",
	    url = "${application.config.payment-url}"
	)
public interface PaymentClient {
	static final Logger log= LoggerFactory.getLogger(PaymentClient.class);
	
	 @PostMapping
	  Integer createPayment(@RequestBody PaymentRequest request);
	}
