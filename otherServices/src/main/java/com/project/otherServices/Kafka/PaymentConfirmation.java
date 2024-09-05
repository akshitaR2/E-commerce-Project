package com.project.otherServices.Kafka;

import java.math.BigDecimal;

import com.project.otherServices.model.PaymentMethod;

public record PaymentConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {

}
