package com.project.orderService.DTO;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.orderService.model.PaymentMethod;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@JsonInclude()
public record OrderRequest(
	    @Positive(message = "Order amount should be positive")
	    BigDecimal amount,
	    @NotNull(message = "Payment method should be precised")
	    PaymentMethod paymentMethod,
	    @NotNull(message = "Customer should be present")
	    @NotEmpty(message = "Customer should be present")
	    @NotBlank(message = "Customer should be present")
	    String customerId,
	    @NotEmpty(message = "You should at least purchase one product")
	    List<PurchaseRequest> products   // List of Products 
	) {

	
}
