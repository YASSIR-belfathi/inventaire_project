package com.inventaire.Inventaire_Vols;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "entities")  // Replace with your entity package

public class InventaireVolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventaireVolsApplication.class, args);
	}

}
