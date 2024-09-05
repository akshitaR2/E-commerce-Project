package com.project.inventoryService.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.inventoryService.DTO.InventoryDTOList;
import com.project.inventoryService.DTO.ResponseDTO;
import com.project.inventoryService.model.Inventory;
import com.project.inventoryService.repository.InventoryRepo;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepo repo;

	@Override
	public void updateInventory(InventoryDTOList dtoList) {
		List<String> skuCodes = dtoList.getInventoryItemsList().stream().map(item -> item.getSkuCode()).toList();
		Map<String, Inventory> inventories = repo.findAllBySkuCodeIn(skuCodes).stream()
				.collect(Collectors.toMap(Inventory::getSkuCode, Function.identity()));

		dtoList.getInventoryItemsList().forEach(item -> {
			Inventory in = inventories.get(item.getSkuCode());
			in.setQuantity(in.getQuantity() + item.getQuantity());
		});

		repo.saveAll(inventories.values());
	}


	@Override
	public boolean checkStatus(List<String> skuCodes) {
		List<ResponseDTO> dtos = repo.findBySkuCodeIn(skuCodes).stream()
				.map(invent -> new ResponseDTO(invent.getSkuCode(), invent.getQuantity() > 0)).toList();
		return dtos.stream().allMatch(dto -> dto.isInStock());

	}
}
