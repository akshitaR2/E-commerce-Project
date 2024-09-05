package com.project.otherServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OtherServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtherServicesApplication.class, args);
	}

}
