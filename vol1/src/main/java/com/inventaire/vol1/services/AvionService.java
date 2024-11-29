package com.inventaire.vol1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventaire.vol1.Repository.AvionRepository;
import com.inventaire.vol1.entity.Avion;

@Service
public class AvionService {
    public final AvionRepository avionRepository;

    public AvionService(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }

    public List<Avion> getListAvion() {
        return avionRepository.findAll();
    }

    public void addAvion(Avion avion) {
        Optional<Avion> avionOptional = avionRepository.findByImmatriculation(avion.getImmatriculation());

        if (avionOptional.isPresent()) {
            throw new IllegalStateException("cette avion est déjà présente");
        } else {
            System.out.println(avion);
        }
        avionRepository.save(avion);
    }

    public void deleteAvion(String Immatriculation) {
        Optional<Avion> avionOptional = avionRepository.findByImmatriculation(Immatriculation);

        if (avionOptional.isPresent()) {
            avionRepository.deleteByImmatriculation(Immatriculation);
        } else {
            throw new IllegalStateException("cette avion n'existe pas");
        }
    }
}
