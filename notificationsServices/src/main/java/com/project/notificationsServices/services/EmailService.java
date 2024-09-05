package com.project.notificationsServices.services;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import com.project.notificationsServices.kafka.DTOs.EmailTemplate;
import com.project.notificationsServices.kafka.DTOs.Product;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	private static final Logger log = LoggerFactory.getLogger(EmailService.class);

	private final JavaMailSender mailService;
	private final SpringTemplateEngine templateEngine;
	public EmailService(JavaMailSender mailService, SpringTemplateEngine templateEngine) {
		super();
		this.mailService = mailService;
		this.templateEngine = templateEngine;
	}
	
	@Async
	public void sendPaymentEmail(String destinationEmail,
	String customerName,
	BigDecimal amount,
	String orderReference) throws MessagingException {
		
		
		MimeMessage mimeMessage = mailService.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());
		helper.setFrom("contact@aliboucoding.com");
		
		final String templateName= EmailTemplate.PAYMENT_CONFIRMATION.getTemplate();
		
		 Map<String, Object> variables = new HashMap<>();
	        variables.put("customerName", customerName);
	        variables.put("amount", amount);
	        variables.put("orderReference", orderReference);

	        Context context = new Context();
	        context.setVariables(variables);
	        helper.setSubject(EmailTemplate.PAYMENT_CONFIRMATION.getSubject());

	        try {
	            String htmlTemplate = templateEngine.process(templateName, context);
	            helper.setText(htmlTemplate, true);

	            helper.setTo(destinationEmail);
//	            mailService.send(mimeMessage); 
	            log.info(String.format("INFO - Email successfully sent to %s with template %s ", destinationEmail, templateName));
	        } catch (MessagingException e) {
	            log.warn("WARNING - Cannot send Email to {} ", destinationEmail);
	        }
	}
	
	 @Async
	    public void sendOrderConfirmationEmail(
	            String destinationEmail,
	            String customerName,
	            BigDecimal amount,
	            String orderReference,
	            List<Product> products
	    ) throws MessagingException {

	        MimeMessage mimeMessage = mailService.createMimeMessage();
	        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
	        messageHelper.setFrom("contact@aliboucoding.com");

	        final String templateName = EmailTemplate.ORDER_CONFIRMATION.getTemplate();

	        Map<String, Object> variables = new HashMap<>();
	        variables.put("customerName", customerName);
	        variables.put("totalAmount", amount);
	        variables.put("orderReference", orderReference);
	        variables.put("products", products);

	        Context context = new Context();
	        context.setVariables(variables);
	        messageHelper.setSubject(EmailTemplate.ORDER_CONFIRMATION.getSubject());

	        try {
	            String htmlTemplate = templateEngine.process(templateName, context);
	            messageHelper.setText(htmlTemplate, true);

	            messageHelper.setTo(destinationEmail);
	            mailService.send(mimeMessage);
	            log.info(String.format("INFO - Email successfully sent to %s with template %s ", destinationEmail, templateName));
	        } catch (MessagingException e) {
	            log.warn("WARNING - Cannot send Email to {} ", destinationEmail);
	        }

	    }
	
}
