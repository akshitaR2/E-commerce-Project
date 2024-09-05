package com.project.orderService.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.orderService.ClientResponse.PurchaseResponse;
import com.project.orderService.DTO.PurchaseRequest;

@FeignClient(
	    name = "productService",
	    url = "${application.config.product-url}"
	)
public interface ProductClient {
	
	

	 @PostMapping("/purchase")
	 public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> requestBody);
	
	 @PostMapping("/revert")
	 public void rollbackProducts(List<PurchaseRequest> requestBody);
	

}
