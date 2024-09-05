package com.project.otherServices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiSwaggerConfig {

	   @Bean
	    public OpenAPI paymentServiceAPI() {
	        return new OpenAPI()
	                .info(new Info().title("Payment Service API")
	                        .description("This is the REST API for Payment Service")
	                        .version("v0.0.1")
	                        .license(new License().name("Apache 2.0")));
//	                .externalDocs(new ExternalDocumentation()
//	                        .description("You can refer to the Product Service Wiki Documentation")
//	                        .url("https://product-service-dummy-url.com/docs"));
	    }
}
