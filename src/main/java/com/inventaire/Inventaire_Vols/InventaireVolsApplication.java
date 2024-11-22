package com.inventaire.Inventaire_Vols;

import com.inventaire.Inventaire_Vols.entities.*;
import com.inventaire.Inventaire_Vols.repositories.PassagerRepository;
import com.inventaire.Inventaire_Vols.repositories.ReservationRepository;
import com.inventaire.Inventaire_Vols.repositories.VolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication

public class InventaireVolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventaireVolsApplication.class, args);
	}
	@Bean
	CommandLineRunner start(PassagerRepository passagerRepository,
							VolRepository volRepository,
							ReservationRepository reservationRepository) {
		return args -> {
			Stream.of("amin el bali", "karim mojid", "adil ramid", "jawad ghalib").forEach(name -> {
				Passager passager = new Passager();
				passager.setNomComplet(name);
				passager.setEmail(name + "@gmail.com");
				passager.setNationalite("marocaine");
				//passagerRepository.save(passager);  // Décommenté pour sauvegarder en base
			});

			passagerRepository.findAll().forEach(passager -> {
				Reservation reservation = new Reservation();
				reservation.setDateReservation(Date.valueOf("2000-12-02"));
				reservation.setPrixTotal(30000);
				reservation.setStatutReservation(StatutReservation.ENCOURS);
				reservation.setPassager(passager);  // Associe la réservation au passager
				//reservationRepository.save(reservation);
			});

			reservationRepository.findAll().forEach(reservation -> {
				Vol vol = new Vol();
				Avion avion = new Avion();  // Crée un avion
				//avion.setModele("Boeing 737");  // Exemple de modèle
				vol.setDate_vol(Date.valueOf("2000-12-02"));
				vol.setVol_IATA("IIO");
				vol.setAeroport_arrive("Agadir Oflla");
				vol.setAeroport_depart("Marrakech Menara");
				vol.setAvion(avion);
				reservation.setVol(vol);  // Associe le vol à la réservation
				//volRepository.save(vol);
			});
          //  Long id = Long.valueOf("2");
			Vol vol1 = volRepository.findById("2").orElse(null);
			if (vol1 != null) {
				System.out.println("================");
				System.out.printf("IATA : %s%n", vol1.getVol_IATA());
				System.out.printf("Aéroport d'arrivée : %s%n", vol1.getAeroport_arrive());
				System.out.printf("Aéroport de départ : %s%n", vol1.getAeroport_depart());
			} else {
				System.out.println("Aucun vol trouvé avec l'ID 2");
			}
		};

}
}
