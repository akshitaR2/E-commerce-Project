package com.project.orderService.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
	private static final Logger log= LoggerFactory.getLogger(OrderProducer.class);
	
	private final KafkaTemplate<String, OrderConfirmation> kafkaTemplat;
	
	
	public OrderProducer(KafkaTemplate<String, OrderConfirmation> kafkaTemplat) {
		super();
		this.kafkaTemplat = kafkaTemplat;
	}


	public void sendOrderConfirmation(OrderConfirmation orderConfirmation) {
		log.info("Sending order confirmation");
		Message<OrderConfirmation> message= MessageBuilder
				.withPayload(orderConfirmation)
				 .setHeader(KafkaHeaders.TOPIC, "order-topic")
				 .build();
		
		kafkaTemplat.send(message);
	}
}
