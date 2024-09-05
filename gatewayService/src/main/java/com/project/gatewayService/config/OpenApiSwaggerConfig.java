package com.project.gatewayService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "v1"))
public class OpenApiSwaggerConfig {
	
	  @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	            .addServersItem(new Server()
	                .url("http://localhost:8222")
	                .description("API Gateway Server"));
	    }
	  
//	  @Bean
//	    public OpenAPI customOpenAPISecurity() {
//	        return new OpenAPI()
//	            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
//	            .components(new Components()
//	                .addSecuritySchemes("bearerAuth",
//	                    new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
//	    }
}

