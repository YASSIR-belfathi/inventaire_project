package com.inventaire.Inventaire_Vols.services;
import java.util.Optional;

import com.inventaire.Inventaire_Vols.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventaire.Inventaire_Vols.entities.Reservation;

@Service
public class PassagerService {


    private ReservationRepository reservationRepository ;

    @Autowired
    public PassagerService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    
    public void removeReservation(long id) {
    	reservationRepository.deleteById(id);
    }
	
    public Reservation updateReservation(Long reservationId, Reservation updatedReservation) {
        Optional<Reservation> existingReservation = reservationRepository.findById(reservationId);
    	
        existingReservation.setVol_reserve(updatedReservation.getVol_reserve());
        existingReservation.setPassager_reservant(updatedReservation.getPassager_reservant());
        existingReservation.setDate_reservation(updatedReservation.getDate_reservation());
        existingReservation.setStatus(updatedReservation.getStatus());
        existingReservation.setPrix_total(updatedReservation.getPrix_total());

    	
        return reservationRepository.save(existingReservation);   
        }

}
