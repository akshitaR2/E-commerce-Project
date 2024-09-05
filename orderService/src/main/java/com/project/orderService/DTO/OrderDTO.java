package com.project.orderService.DTO;

public class OrderDTO {
	    private String skuCode;
	    private double price;
	    private Integer quantity;
		public OrderDTO(  String skuCode, double price, Integer quantity) {
			super();
			this.skuCode = skuCode;
			this.price = price;
			this.quantity = quantity;
		}
		public OrderDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
	
		public String getSkuCode() {
			return skuCode;
		}
		public void setSkuCode(String skuCode) {
			this.skuCode = skuCode;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
	    
	    
}
