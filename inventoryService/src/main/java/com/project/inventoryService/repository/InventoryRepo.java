package com.project.inventoryService.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.inventoryService.model.Inventory;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer>{


	List<Inventory> findAllBySkuCodeIn(List<String> skuCodes);

	List<Inventory> findBySkuCodeIn(List<String> skuCodes);

	boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);


}
