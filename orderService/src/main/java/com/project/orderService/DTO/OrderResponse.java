package com.project.orderService.DTO;

import java.math.BigDecimal;

import com.project.orderService.model.PaymentMethod;

public record OrderResponse(
	    Integer id,
	    String reference,
	    BigDecimal amount,
	    PaymentMethod paymentMethod,
	    String customerId
	) {

}
