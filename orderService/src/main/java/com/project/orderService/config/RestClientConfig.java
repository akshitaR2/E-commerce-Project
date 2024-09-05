//package com.project.orderService.config;
//
//import java.time.Duration;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.client.ClientHttpRequestFactories;
//import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.web.client.RestClient;
//import org.springframework.web.client.support.RestClientAdapter;
//import org.springframework.web.service.invoker.HttpServiceProxyFactory;
//
//import com.project.orderService.client.ProductClient;
//
//
//@Configuration
//public class RestClientConfig {
//	
//	@Value("${application.config.product-url}")
//	private String productClientUrl;
//
//	@Bean
//	public ProductClient productClient() {
//
//		RestClient restClient = RestClient.builder()
//		  .baseUrl(productClientUrl)
//		  .requestFactory(getClientRequestFactory())
//		  .build();
//		 var restClientAdapter = RestClientAdapter.create(restClient);
//	        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
//	        return httpServiceProxyFactory.createClient(ProductClient.class);
//	}
//	
//
//	
//	  private ClientHttpRequestFactory getClientRequestFactory() {
//	        ClientHttpRequestFactorySettings clientHttpRequestFactorySettings = ClientHttpRequestFactorySettings.DEFAULTS
//	                .withConnectTimeout(Duration.ofSeconds(3))
//	                .withReadTimeout(Duration.ofSeconds(3));
//	        return ClientHttpRequestFactories.get(clientHttpRequestFactorySettings);
//	    }
//}
