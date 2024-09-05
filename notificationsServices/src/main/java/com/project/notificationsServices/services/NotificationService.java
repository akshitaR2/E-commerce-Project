//package com.project.notificationsServices.services;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//
//public class NotificationService {
//	
//	private final Logger log=LoggerFactory.getLogger(NotificationService.class);
//	
//
//	 @KafkaListener(topics = "order_topic", groupId = "notification_group")
//	    public void listen(String message) {
//		 log.info("Received message: " + message);	
//		 
//	 }
//
//}
