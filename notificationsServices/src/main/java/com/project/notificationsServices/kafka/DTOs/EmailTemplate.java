package com.project.notificationsServices.kafka.DTOs;

public enum EmailTemplate {
	PAYMENT_CONFIRMATION("payment_confirmation.html","Payment successfully processed"),
	ORDER_CONFIRMATION("order_confirmation.html","Order successfully placed");
	
	    private final String template;
	    private final String subject;
	    
		public String getTemplate() {
			return template;
		}
		public String getSubject() {
			return subject;
		}
		private EmailTemplate(String template, String subject) {
			this.template = template;
			this.subject = subject;
		}
	    
	
}
