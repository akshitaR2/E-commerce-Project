package com.project.otherServices.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.otherServices.DTOs.PaymentRequest;
import com.project.otherServices.Kafka.PaymentConfirmation;
import com.project.otherServices.Kafka.PaymentNotifyProducer;
import com.project.otherServices.model.Payment;
import com.project.otherServices.repository.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService {
	

	private final PaymentRepo repo;
	private final PaymentNotifyProducer notificationProducer;
	
	public PaymentServiceImpl(PaymentRepo repo,PaymentNotifyProducer notificationProducer) {
		super();
		this.repo = repo;
		this.notificationProducer=notificationProducer;
	}


	@Override
	@Transactional
	public Integer createPayment(PaymentRequest request) {
		
	var payment=repo.save(new Payment(
				request.amount(),
				request.paymentMethod(),
				request.orderId()));
	
	this.notificationProducer.sendNotification(new PaymentConfirmation(
			request.orderReference(),
			request.amount(),
			request.paymentMethod(),
			request.customer().firstname(), 
			request.customer().lastname(),
			request.customer().email()));
		return payment.getId();
	}

}
