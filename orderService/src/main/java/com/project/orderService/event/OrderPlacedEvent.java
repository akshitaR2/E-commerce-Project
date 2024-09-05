package com.project.orderService.event;

public class OrderPlacedEvent {
private String orderNumber;
private String email ="mailtoakshitar@gmail.com";
public OrderPlacedEvent() {
	super();
	// TODO Auto-generated constructor stub
}
public OrderPlacedEvent(String orderNumber, String email) {
	super();
	this.orderNumber = orderNumber;
	this.email = email;
}
public String getOrderNumber() {
	return orderNumber;
}
public void setOrderNumber(String orderNumber) {
	this.orderNumber = orderNumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

 
}
