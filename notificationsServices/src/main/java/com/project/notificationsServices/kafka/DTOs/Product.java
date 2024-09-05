package com.project.notificationsServices.kafka.DTOs;

import java.math.BigDecimal;

public record Product(
        String productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {

}
