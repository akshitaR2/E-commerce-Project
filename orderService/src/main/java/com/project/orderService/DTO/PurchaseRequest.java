package com.project.orderService.DTO;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
public record PurchaseRequest(  
        @NotNull(message = "Product is mandatory")
        String productId,
        @Positive(message = "Quantity is mandatory")
        double quantity
) {

}
