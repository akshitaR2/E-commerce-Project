package com.project.productService.DTO;

import java.math.BigDecimal;

public record ProductResponse(
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        Integer categoryId,
        String productId,
        String categoryName
) {
}
