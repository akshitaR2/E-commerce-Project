package com.project.otherServices.services;

import com.project.otherServices.DTOs.PaymentRequest;

import jakarta.validation.Valid;

public interface PaymentService {

	Integer createPayment(PaymentRequest request);

}
