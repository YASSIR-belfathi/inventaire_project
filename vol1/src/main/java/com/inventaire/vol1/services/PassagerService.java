package com.inventaire.vol1.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventaire.vol1.Repository.PassagerRepository;
// import com.inventaire.vol1.Repository.ReservationRepository;
import com.inventaire.vol1.entity.Passager;
// import com.inventaire.vol1.entity.Reservation;

import jakarta.transaction.Transactional;

@Service
public class PassagerService {

    // private final ReservationRepository reservationRepository;
    private final PassagerRepository passagerRepository;

    public PassagerService(PassagerRepository passagerRepository) {
        // this.reservationRepository=reservationRepository;
        this.passagerRepository = passagerRepository;
    }

    // public List<Reservation> getReservation(){
    // return reservationRepository.findAll();
    // }

    public List<Passager> listPassager() {
        return passagerRepository.findAll();
    }

    public void addPassager(Passager passager) {
        Optional<Passager> passgerOptional = passagerRepository.findByName(passager.getNom_complet());

        if (passgerOptional.isPresent()) {
            throw new IllegalStateException("ce passager existe déjà");
        } else {
            System.out.println(passager);
        }

        passagerRepository.save(passager);
    }

    public void deletePassager(int Id) {
        Optional<Passager> passagerOptional = passagerRepository.findById(Id);

        if (passagerOptional.isPresent()) {
            passagerRepository.deleteById(Id);
        }

        else {
            throw new IllegalStateException("ce passager n'existe pas dans la base de données");
        }
    }

    @Transactional
    public void updatePassager(int id, String name, String num_passport, String CIN, String nationality,
            Integer telephone) {
        Passager passager = passagerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("the passager with the id:" + id + "doesn't exist"));

        if (name != null && name.length() > 0 && !Objects.equals(name, passager.getNom_complet())) {
            passager.setNom_complet(name);
        }

        if (num_passport != null && num_passport.length() > 0
                && !Objects.equals(num_passport, passager.getNum_carte_identifie())) {
            passager.setNum_passport(num_passport);
        }

        if (CIN != null && CIN.length() > 0 && !Objects.equals(CIN, passager.getNum_carte_identifie())) {
            passager.setNum_carte_identifie(CIN);
        }

        if (nationality != null && nationality.length() > 0
                && !Objects.equals(nationality, passager.getNationnalite())) {
            passager.setNationnalite(nationality);
        }

        if (telephone != null && Integer.toString(telephone).length() > 0
                && !Objects.equals(telephone, passager.getTelephone())) {
            passager.setTelephone(telephone);
        }
    }
}
