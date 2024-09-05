//package com.project.orderService.client;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.service.annotation.GetExchange;
//
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import io.github.resilience4j.retry.annotation.Retry;
//
//
//
//public interface InventoryClient {
//	
//	static final Logger log= LoggerFactory.getLogger(InventoryClient.class);
//	
//	
//	 @GetExchange(value =  "/inventory/api")
//	 @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
//	    @Retry(name = "inventory")
//	 boolean isInStock(@RequestParam List<String> skuCodes);
//	
//	 default boolean fallbackMethod(List<String> skuCodes, Throwable throwable) {
//		    log.info("Cannot get inventory for skucodes {}, failure reason: {}", skuCodes, throwable.getMessage());
//		    return false;
//		}
//
//}
