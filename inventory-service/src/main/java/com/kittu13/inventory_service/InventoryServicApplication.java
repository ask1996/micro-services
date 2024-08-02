package com.kittu13.inventory_service;

import com.kittu13.inventory_service.model.Inventory;
import com.kittu13.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServicApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServicApplication.class, args);
	}

	@Bean
	public CommandLineRunner LoadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inv1 = new Inventory();
			inv1.setQuantity(3);
			inv1.setSkuCode("iphone_13");

			Inventory inv2 = new Inventory();
			inv2.setQuantity(3);
			inv2.setSkuCode("iphone_14");
			inventoryRepository.save(inv2);
			inventoryRepository.save(inv1);

		};
	}

}
