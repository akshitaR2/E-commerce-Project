package com.project.gatewayService.config;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class GetUrls {
	  private final DiscoveryClient discoveryClient;

	    public GetUrls(DiscoveryClient discoveryClient) {
	        this.discoveryClient = discoveryClient;
	    }

		public String getProductUrl() {
			  List<ServiceInstance> instances = discoveryClient.getInstances("productService");
		        if (instances.isEmpty()) {
		            return "error";
		        }
		        ServiceInstance instance = instances.get(0);
		        return instance.getUri().toString();
			
		}

		public String getCustomerUrl() {
			  List<ServiceInstance> instances = discoveryClient.getInstances("customerService");
		        if (instances.isEmpty()) {
		            return "error";
		        }
		        ServiceInstance instance = instances.get(0);
		        return instance.getUri().toString();
		}

		public String getOrderUrl() {
			  List<ServiceInstance> instances = discoveryClient.getInstances("orderService");
		        if (instances.isEmpty()) {
		            return "error";
		        }
		        ServiceInstance instance = instances.get(0);
		        return instance.getUri().toString();
		}

	   
	  
	        
	    

}
