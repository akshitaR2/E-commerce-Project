package com.project.orderService.kafka;

import java.math.BigDecimal;
import java.util.List;
import com.project.orderService.ClientResponse.PurchaseResponse;
import com.project.orderService.ClientResponse.CustomerResponse;
import com.project.orderService.model.PaymentMethod;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {

}
