package com.project.otherServices.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class PaymentNotifyProducer {
	private static final Logger log= LoggerFactory.getLogger(PaymentNotifyProducer.class); 
	
	private final KafkaTemplate<String, PaymentNotifyProducer> kafkaTemplate;
	
	

	public PaymentNotifyProducer(KafkaTemplate<String, PaymentNotifyProducer> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}



	public void sendNotification(PaymentConfirmation request) {
	    log.info("Sending notification with body = < {} >", request);
	    Message<PaymentConfirmation> message = MessageBuilder
	            .withPayload(request)
	            .setHeader(KafkaHeaders.TOPIC, "payment-topic")
	            .build();

	    kafkaTemplate.send(message);
	  }
}
