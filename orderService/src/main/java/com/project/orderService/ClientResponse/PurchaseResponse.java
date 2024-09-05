package com.project.orderService.ClientResponse;

import java.math.BigDecimal;

public record PurchaseResponse(
        String productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}

