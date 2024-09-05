package com.project.otherServices.DTOs;

import java.math.BigDecimal;

import com.project.otherServices.model.Customer;
import com.project.otherServices.model.PaymentMethod;

public record PaymentRequest(
		
		    BigDecimal amount,
		    PaymentMethod paymentMethod,
		    Integer orderId,
		    String orderReference,
		    Customer customer
		) {

}
