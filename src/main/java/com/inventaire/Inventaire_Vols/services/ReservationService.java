package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Administrateur;
import com.inventaire.Inventaire_Vols.entities.Reservation;

import java.util.List;

public interface ReservationService {
     Reservation saveReservation(Reservation reservation);
     List<Reservation> findAllReservations();
     Reservation findReservationById(Long id);
     void deleteReservation(Long id);
     void confirmReservation(Long id);
     void cancelReservation(Long id);
     double calculateTotalPrice(Long reservationId);
}
