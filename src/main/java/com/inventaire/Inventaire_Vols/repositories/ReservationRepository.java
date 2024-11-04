package com.inventaire.Inventaire_Vols.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.inventaire.Inventaire_Vols.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
