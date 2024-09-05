package com.project.productService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.productService.DTO.ProductDTO;
import com.project.productService.DTO.ProductPurchaseRequest;
import com.project.productService.DTO.ProductResponse;
import com.project.productService.DTO.PurchaseResponse;
import com.project.productService.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product/api")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
//	
//	@GetMapping
//	public List<ProductDTO> allProducts( ) {
//		return service.getAllProducts();
//	}
//	
//	@PostMapping("/add")
//	public ProductDTO addProduct(@RequestBody ProductDTO dto) {
//		return service.addProduct(dto);
//	}
	
	 @PostMapping
	    public ResponseEntity<String> createProduct(
	            @RequestBody @Valid ProductDTO request
	    ) {
	        return ResponseEntity.ok(service.createProduct(request));
	    }

	    @PostMapping("/purchase")
	    public ResponseEntity<List<PurchaseResponse>> purchaseProducts(
	            @RequestBody List<ProductPurchaseRequest> request
	    ) {
	        return ResponseEntity.ok(service.purchaseProducts(request));
	    }

	    @GetMapping("/{product-id}")
	    public ResponseEntity<ProductResponse> findById(
	            @PathVariable("product-id") String productId
	    ) {
	        return ResponseEntity.ok(service.findById(productId));
	    }

	    @GetMapping
	    public ResponseEntity<List<ProductResponse>> findAll() {
	        return ResponseEntity.ok(service.findAll());
	    }

	    @PostMapping("/revert")
		 public void rollbackProducts(@RequestBody List<ProductPurchaseRequest> request) {
	    	service.rollbackProducts(request);
	    }
}
