package com.project.notificationsServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NotificationsServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationsServicesApplication.class, args);
	}

}
