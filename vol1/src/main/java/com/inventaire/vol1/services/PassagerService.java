package com.inventaire.vol1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventaire.vol1.Repository.ReservationRepository;
import com.inventaire.vol1.entity.Reservation;

@Service
public class PassagerService {
    
    private final ReservationRepository reservationRepository;


    public PassagerService(ReservationRepository reservationRepository)
    {
        this.reservationRepository=reservationRepository;
    }

    public List<Reservation> getReservation(){
        return reservationRepository.findAll();
    }
}
