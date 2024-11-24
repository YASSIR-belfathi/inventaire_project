package com.inventaire.vol1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventaire.vol1.Repository.PassagerRepository;
// import com.inventaire.vol1.Repository.ReservationRepository;
import com.inventaire.vol1.entity.Passager;
// import com.inventaire.vol1.entity.Reservation;

@Service
public class PassagerService {
    
    // private final ReservationRepository reservationRepository;
    private final PassagerRepository passagerRepository;


    public PassagerService(PassagerRepository passagerRepository)
    {
        // this.reservationRepository=reservationRepository;
        this.passagerRepository=passagerRepository;
    }

    // public List<Reservation> getReservation(){
    //     return reservationRepository.findAll();
    // }

    public List<Passager> listPassager(){
        return passagerRepository.findAll();
    }

    public void addPassager(Passager passager)
    {
        Optional<Passager> passgerOptional=passagerRepository.findByName(passager.getNom_complet());

        if(passgerOptional.isPresent())
        {
            throw new IllegalStateException("ce passager existe déjà");
        }
        else{
            System.out.println(passager);
        }

        passagerRepository.save(passager);
    }

    public void deletePassager(int Id)
    {
        Optional<Passager> passagerOptional=passagerRepository.findById(Id);

        if(passagerOptional.isPresent()){
            passagerRepository.deleteById(Id);
        }

        else{
            throw new IllegalStateException("ce passager n'existe pas dans la base de données");
        }
    }
}
