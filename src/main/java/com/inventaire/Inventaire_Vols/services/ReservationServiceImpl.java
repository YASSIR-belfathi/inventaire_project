package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Reservation;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    @Override
    public Reservation saveReservation(Reservation reservation) {
        return null;
    }

    @Override
    public List<Reservation> findAllReservations() {
        return List.of();
    }

    @Override
    public Reservation findReservationById(Long id) {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {

    }

    @Override
    public void confirmReservation(Long id) {

    }

    @Override
    public void cancelReservation(Long id) {

    }

    @Override
    public double calculateTotalPrice(Long reservationId) {
        return 0;
    }
}
