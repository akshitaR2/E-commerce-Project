package com.project.inventoryService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String skuCode;
    private Integer quantity;
	public Inventory(String skuCode, Integer quantity) {
		super();
		this.skuCode = skuCode;
		this.quantity = quantity;
	}
	public Inventory() {
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
