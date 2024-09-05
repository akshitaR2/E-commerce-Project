package com.project.productService.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Category {
	 @Id
	    @GeneratedValue
	    private Integer id;
	    private String name;
	    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
	    private List<Product> products;
		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Category(Integer id, String name, List<Product> products) {
			super();
			this.id = id;
			this.name = name;
			this.products = products;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Product> getProducts() {
			return products;
		}
		public void setProducts(List<Product> products) {
			this.products = products;
		}
	    
	    
}
