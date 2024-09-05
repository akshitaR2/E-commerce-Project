package com.project.inventoryService.service;

import java.util.List;

import com.project.inventoryService.DTO.InventoryDTOList;
import com.project.inventoryService.DTO.ResponseDTO;

public interface InventoryService {

	void updateInventory(InventoryDTOList dto);

	boolean checkStatus(List<String> skuCodes);

}
