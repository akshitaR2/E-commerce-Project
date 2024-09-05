package com.project.productService.service;

import java.util.List;

import com.project.productService.DTO.ProductDTO;
import com.project.productService.DTO.ProductPurchaseRequest;
import com.project.productService.DTO.ProductResponse;
import com.project.productService.DTO.PurchaseResponse;

import jakarta.validation.Valid;

public interface ProductService {

//	List<ProductDTO> getAllProducts();
//
//	ProductDTO addProduct(ProductDTO dto);

	String createProduct( ProductDTO request);

	List<PurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);

	List<ProductResponse> findAll();

	ProductResponse findById(String productId);

	void rollbackProducts(List<ProductPurchaseRequest> request);

}
