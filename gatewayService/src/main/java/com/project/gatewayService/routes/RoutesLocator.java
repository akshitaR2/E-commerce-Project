package com.project.gatewayService.routes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import com.project.gatewayService.config.GetUrls;

import java.net.URI;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;

@Configuration
public class RoutesLocator {
	private static final Logger log=LoggerFactory.getLogger(RoutesLocator.class);
	
	@Autowired
	private GetUrls fromURLS;
	
	  @Bean
	    public RouterFunction<ServerResponse> productServiceSwaggerRoute() {
		  log.info("productServiceSwaggerRoute url"+fromURLS.getProductUrl());
	        return GatewayRouterFunctions.route("product_service_swagger")
	                .route(RequestPredicates.path("/aggregate/productService/v3/api-docs"), HandlerFunctions.http(fromURLS.getProductUrl()))
	                .filter(setPath("/api-docs"))
	                .build();
	    }
	  
	  @Bean
	    public RouterFunction<ServerResponse> orderServiceSwaggerRoute() {
	        return GatewayRouterFunctions.route("order_service_swagger")
	                .route(RequestPredicates.path("/aggregate/orderService/v3/api-docs"), HandlerFunctions.http(fromURLS.getOrderUrl()))
	              
	                .filter(setPath("/api-docs"))
	                .build();
	    }
	  
	  @Bean
	    public RouterFunction<ServerResponse> customerServiceSwaggerRoute() {
	        return GatewayRouterFunctions.route("order_service_swagger")
	                .route(RequestPredicates.path("/aggregate/customerService/v3/api-docs"), HandlerFunctions.http(fromURLS.getCustomerUrl()))
	              
	                .filter(setPath("/api-docs"))
	                .build();
	    }
}
