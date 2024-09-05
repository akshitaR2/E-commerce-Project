package com.project.productService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
//@Table(name = "products")
public class Product {
		@Id
	    @GeneratedValue(strategy = GenerationType.UUID)
	    private UUID id;
//	    private Integer id;
	    private String name;
	    private String description;
//	    private String skucode;
	    private double availableQuantity;
	    private BigDecimal price;
	    @ManyToOne
	    @JoinColumn(name = "category_id")
	    private Category category;
	    
	  public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
	  

	public Product(String id, String name, String description, double availableQuantity,
			BigDecimal price, Category category) {
		super();
		this.id = UUID.fromString(id);
		this.name = name;
		this.description = description;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.category = category;
	}


	public Product(String name, String description, double availableQuantity, BigDecimal price,
			Category category) {
		super();
		this.name = name;
		this.description = description;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.category = category;
	}
	
	public Product(String name, String description, double availableQuantity, BigDecimal price) {
		super();
		this.name = name;
		this.description = description;
		this.availableQuantity = availableQuantity;
		this.price = price;
	}


	public String getId() {
		return id.toString();
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


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	private String generateUniqueId() {
	        return UUID.randomUUID().toString();
	    }
	
	
}
