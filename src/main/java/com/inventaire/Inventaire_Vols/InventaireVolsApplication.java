package com.inventaire.Inventaire_Vols;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "entities")  

public class InventaireVolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventaireVolsApplication.class, args);
	}

}
