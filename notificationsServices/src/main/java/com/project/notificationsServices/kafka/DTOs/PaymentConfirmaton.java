package com.project.notificationsServices.kafka.DTOs;

import java.math.BigDecimal;


public record PaymentConfirmaton(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {

}
