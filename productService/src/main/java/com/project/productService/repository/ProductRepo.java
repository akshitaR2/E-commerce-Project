package com.project.productService.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.productService.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, UUID> {

	
//	 List<Product> findAllBySkuCodeInOrderBySkuCode(List<String> productIds);

	List<Product>  findAllByIdInOrderById(List<String> productIds);
}
 