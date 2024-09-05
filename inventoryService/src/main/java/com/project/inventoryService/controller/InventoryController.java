package com.project.inventoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.inventoryService.DTO.InventoryDTOList;
import com.project.inventoryService.DTO.ResponseDTO;
import com.project.inventoryService.service.InventoryService;

@RestController
@RequestMapping("/inventory/api")
public class InventoryController {
	
	@Autowired
	InventoryService service;
	

	@PostMapping("/update")
	public String updateInventory(@RequestBody InventoryDTOList dto) {
		try {
		service.updateInventory(dto);
		return "ineventory is updated";
		}
		catch (Exception e) {
			return "something went wrong with update";
		}
		
	}
	
	
	   @GetMapping
	    @ResponseStatus(code = HttpStatus.OK)
	    public boolean isInStock( @RequestParam List<String> skuCodes) {
	        return service.checkStatus(skuCodes);
	    }

	
}
