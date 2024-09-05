//package com.project.orderService.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "order_items")
//public class OrderItems {
//	 @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private Long id;
//	    private String skuCode;
//	    private double price;
//	    private Integer quantity;
//		public OrderItems(Long id, String skuCode, double price, Integer quantity) {
//			super();
//			this.id = id;
//			this.skuCode = skuCode;
//			this.price = price;
//			this.quantity = quantity;
//		}
//		public OrderItems() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//		public Long getId() {
//			return id;
//		}
//		public void setId(Long id) {
//			this.id = id;
//		}
//		
//		public String getSkuCode() {
//			return skuCode;
//		}
//		public void setSkuCode(String skuCode) {
//			this.skuCode = skuCode;
//		}
//		public double getPrice() {
//			return price;
//		}
//		public void setPrice(double price) {
//			this.price = price;
//		}
//		public Integer getQuantity() {
//			return quantity;
//		}
//		public void setQuantity(Integer quantity) {
//			this.quantity = quantity;
//		}
//	    
//	    
//}
