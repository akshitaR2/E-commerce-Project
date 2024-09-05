package com.project.productService.model;

import org.springframework.stereotype.Component;

import com.project.productService.DTO.ProductDTO;
import com.project.productService.DTO.ProductResponse;
import com.project.productService.DTO.PurchaseResponse;

@Component
public class ProductMapper {

	public Product toProduct(ProductDTO request) {
        return new Product(request.getName(), 
        	
        		request.getDescription(), 
        		request.getAvailableQuantity(),
        		request.getPrice());
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getId(),
                product.getCategory().getName() 
        );
    }

    public PurchaseResponse toproductPurchaseResponse(Product product, double quantity) {
     return new PurchaseResponse(product.getId(), 
    		 product.getName(),
    		 product.getDescription(),
    		 product.getPrice(),
    		 quantity);
    }
}
