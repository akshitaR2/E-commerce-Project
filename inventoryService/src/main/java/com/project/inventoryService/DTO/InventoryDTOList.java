package com.project.inventoryService.DTO;

import java.util.List;

public class InventoryDTOList {
	List<InventoryDTO> inventoryItemsList;

	

	public InventoryDTOList() {
		super();
		// TODO Auto-generated constructor stub
	}



	public InventoryDTOList(List<InventoryDTO> inventoryItemsList) {
		super();
		this.inventoryItemsList = inventoryItemsList;
	}



	public List<InventoryDTO> getInventoryItemsList() {
		return inventoryItemsList;
	}



	public void setInventoryItemsList(List<InventoryDTO> inventoryItemsList) {
		this.inventoryItemsList = inventoryItemsList;
	}



	public static class InventoryDTO {
		private String skuCode;
		private Integer quantity;

		public InventoryDTO(String skuCode, Integer quantity) {
			super();
			this.skuCode = skuCode;
			this.quantity = quantity;
		}

		public InventoryDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getSkuCode() {
			return skuCode;
		}

		public void setSkuCode(String skuCode) {
			this.skuCode = skuCode;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
	}

}
