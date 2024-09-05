package com.project.inventoryService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.inventoryService.model.Inventory;
import com.project.inventoryService.repository.InventoryRepo;

@SpringBootApplication
public class InventoryServiceApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner loadData(InventoryRepo repo) {
//		return args->{
//			Inventory in2=new Inventory("13IP", 0);
//			Inventory in1=new Inventory("15IP", 7);
//			repo.save(in2);
//			repo.save(in1);
//		};
//	}

}
