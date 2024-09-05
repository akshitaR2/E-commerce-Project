package com.project.otherServices.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.otherServices.DTOs.PaymentRequest;
import com.project.otherServices.services.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payment/api")
public class PaymentController {
	
	private final PaymentService service;
	

	 public PaymentController(PaymentService service) {
		super();
		this.service = service;
	}


	@PostMapping
	  public ResponseEntity<Integer> createPayment(
	      @RequestBody @Valid PaymentRequest request
	  ) {
	    return ResponseEntity.ok(this.service.createPayment(request));
	  }
}
