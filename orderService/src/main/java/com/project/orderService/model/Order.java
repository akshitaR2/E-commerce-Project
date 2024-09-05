package com.project.orderService.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.random.RandomGenerator;

import org.hibernate.id.UUIDGenerator;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer_orders")
public class Order {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;

	  private String reference = generateUUID();
	  private BigDecimal totalAmount;
	  private String status ="open";
	  @Enumerated(EnumType.STRING)
	  private PaymentMethod paymentMethod;

	  private String customerId;

	  @OneToMany(mappedBy = "order")
	  private List<OrderLine> orderLines;

	  @CreatedDate
	  @Column(updatable = false, nullable = false)
	  private LocalDateTime createdDate;

	  @LastModifiedDate
	  @Column(insertable = false)
	  private LocalDateTime lastModifiedDate;

	public Order( PaymentMethod paymentMethod, String customerId) {
		super();
		this.paymentMethod = paymentMethod;
		this.customerId = customerId;
	}

	public Order(Integer id, String reference, BigDecimal totalAmount, String status, PaymentMethod paymentMethod,
			String customerId, List<OrderLine> orderLines, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
		super();
		this.id = id;
		this.reference = reference;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.customerId = customerId;
		this.orderLines = orderLines;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	    

	private String generateUUID() {
	
		return UUID.randomUUID().toString();
	}

	    
}
