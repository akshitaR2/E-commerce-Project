package com.project.notificationsServices.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import static java.lang.String.format;

import com.project.notificationsServices.kafka.DTOs.OrderConfirmation;
import com.project.notificationsServices.kafka.DTOs.PaymentConfirmaton;

import jakarta.mail.MessagingException;


@Service
public class NotificationConsumer {
	
	private static final Logger log= LoggerFactory.getLogger(NotificationConsumer.class);
	private final EmailService emailService;
	
	
	
	public NotificationConsumer(EmailService emailService) {
		super();
		this.emailService = emailService;
	}




	@KafkaListener(topics = "payment-topic")
	public void paymentNotificationconsumer(PaymentConfirmaton confirmation) throws MessagingException {
		 log.info(format("Consuming the message from payment-topic Topic:: %s", confirmation));
		 
		 this.emailService.sendPaymentEmail(confirmation.customerEmail(),
				 confirmation.customerFirstname(),confirmation.amount() ,confirmation.orderReference());
	}
	
	
	
	
	 @KafkaListener(topics = "order-topic")
	    public void consumeOrderConfirmationNotifications(OrderConfirmation confirmation) throws MessagingException {
	        log.info(format("Consuming the message from order-topic Topic:: %s", confirmation));
	        this.emailService.sendOrderConfirmationEmail(confirmation.customer().email(),
				 confirmation.customer().firstname(),confirmation.totalAmount() ,confirmation.orderReference(),confirmation.products());
	 }
}
