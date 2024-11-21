package com.inventaire.vol1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EntityScan("com.inventaire.vol1.entity")
@EnableJpaRepositories("com.inventaire.vol1.Repository")
public class Vol1Application {

	public static void main(String[] args) {
		SpringApplication.run(Vol1Application.class, args);
	}
}
