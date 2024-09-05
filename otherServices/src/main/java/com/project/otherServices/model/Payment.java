package com.project.otherServices.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Payment {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;

	  private BigDecimal amount;

	  @Enumerated(EnumType.STRING)
	  private PaymentMethod paymentMethod;

	  private Integer orderId;

	  @CreatedDate
	  @Column(updatable = false, nullable = false)
	  private LocalDateTime createdDate;

	  @LastModifiedDate
	  @Column(insertable = false)
	  private LocalDateTime lastModifiedDate;

	public Payment(Integer id, BigDecimal amount, PaymentMethod paymentMethod, Integer orderId,
			LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.orderId = orderId;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	

	public Payment(BigDecimal amount, PaymentMethod paymentMethod, Integer orderId) {
		super();
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.orderId = orderId;
	}



	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	  
	  
}
