package com.project.orderService.ClientResponse;

import java.math.BigDecimal;

import com.project.orderService.model.PaymentMethod;


public record PaymentRequest(
		    BigDecimal amount,
		    PaymentMethod paymentMethod,
		    Integer orderId,
		    String orderReference,
		    CustomerResponse customer
		) {

}
