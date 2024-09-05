package com.project.inventoryService.DTO;

public class ResponseDTO {
	 private String skuCode;
	    private boolean isInStock;
		public ResponseDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ResponseDTO(String skuCode, boolean isInStock) {
			super();
			this.skuCode = skuCode;
			this.isInStock = isInStock;
		}
		public String getSkuCode() {
			return skuCode;
		}
		public void setSkuCode(String skuCode) {
			this.skuCode = skuCode;
		}
		public boolean isInStock() {
			return isInStock;
		}
		public void setInStock(boolean isInStock) {
			this.isInStock = isInStock;
		}

}
