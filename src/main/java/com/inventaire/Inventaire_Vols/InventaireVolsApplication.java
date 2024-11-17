package com.inventaire.Inventaire_Vols;

import com.inventaire.Inventaire_Vols.entities.Passager;
import com.inventaire.Inventaire_Vols.repositories.PassagerRepository;
import com.inventaire.Inventaire_Vols.repositories.ReservationRepository;
import com.inventaire.Inventaire_Vols.repositories.VolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication

public class InventaireVolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventaireVolsApplication.class, args);
	}
	@Bean
CommandLineRunner start(PassagerRepository passagerRepository,
						VolRepository volRepository,
						ReservationRepository reservationRepository){
		return args -> {
			Stream.of("amin el bali","karim mojid","adil ramid","jawad ghalib").forEach(name ->{
				Passager passger = new Passager();
				passger.setNomComplet(name);
				passger.setEmail(name+"@gmail.com");
				passger.setTelephone("0765758556");
				passger.setNationalite("marocainne");
				passagerRepository.save(passger);
			});
		};

}
}
