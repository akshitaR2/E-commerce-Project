package com.project.productService.DTO;

import java.math.BigDecimal;

public class ProductDTO {
	 private String name;
	    private String description;
	    private double availableQuantity;
	    private BigDecimal price;
		
		public ProductDTO(String name, String description, double availableQuantity, BigDecimal price) {
			super();
			this.name = name;
			this.description = description;
			this.availableQuantity = availableQuantity;
			this.price = price;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getAvailableQuantity() {
			return availableQuantity;
		}
		public void setAvailableQuantity(double availableQuantity) {
			this.availableQuantity = availableQuantity;
		}
		
		
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public ProductDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
	
	    

	
}
