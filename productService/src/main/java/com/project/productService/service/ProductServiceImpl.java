package com.project.productService.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.productService.DTO.ProductDTO;
import com.project.productService.DTO.ProductPurchaseRequest;
import com.project.productService.DTO.ProductResponse;
import com.project.productService.DTO.PurchaseResponse;
import com.project.productService.exceptions.ProductPurchaseException;
import com.project.productService.model.Product;
import com.project.productService.model.ProductMapper;
import com.project.productService.repository.ProductRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo repo;
	
    private final ProductMapper mapper;
    
    

	public ProductServiceImpl(ProductMapper mapper) {
		super();
		this.mapper = mapper;
	}

//	@Override
//	public List<ProductDTO> getAllProducts() {
//		return repo.findAll().stream().map(product -> 
//			new ProductDTO(product.getId(), 
//					product.getName(),
//				    product.getDescription(), 
//				    product.getSkuCode(), 
//				    product.getPrice()))
//				.toList();
//
//	}
//
//	@Override
//	@Transactional
//	public ProductDTO addProduct(ProductDTO dto) {
//		Product product = new Product();
//		product.setDescription(dto.getDescription());
//		product.setName(dto.getName());
//		product.setPrice(dto.getPrice());
//		product.setSkuCode(dto.getSkuCode());
//		product= repo.save(product);
//		dto.setId(product.getId());
//		return dto;
//	}



    public String createProduct(
            ProductDTO request
    ) {
        var product = mapper.toProduct(request);
        return repo.save(product).getId();
    }

    public ProductResponse findById(String id) {
        return repo.findById(UUID.fromString(id))
                .map(mapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID:: " + id));
    }

    public List<ProductResponse> findAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = ProductPurchaseException.class)
    public List<PurchaseResponse> purchaseProducts(
            List<ProductPurchaseRequest> request
    ) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        var storedProducts = repo.findAllByIdInOrderById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }
        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<PurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            repo.save(product);
            purchasedProducts.add(mapper.toproductPurchaseResponse(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }

	@Override
	public void rollbackProducts(List<ProductPurchaseRequest> request) {
		 var productIds = request
	                .stream()
	                .map(ProductPurchaseRequest::productId)
	                .toList();
	        var products = repo.findAllByIdInOrderById(productIds);

	        Map<String, Double> idToQuantityMap = request.stream()
	                .collect(Collectors.toMap(ProductPurchaseRequest::productId,ProductPurchaseRequest::quantity));

	        // Update list1 based on the map
	        products.forEach(item -> {
	            if (idToQuantityMap.containsKey(item.getId())) {
	                item.setAvailableQuantity(idToQuantityMap.get(item.getId())+item.getAvailableQuantity());
	            }
	        });
	        repo.saveAll(products);
	}



}
