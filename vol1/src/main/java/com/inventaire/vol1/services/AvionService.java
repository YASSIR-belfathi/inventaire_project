package com.inventaire.vol1.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventaire.vol1.Repository.AvionRepository;
import com.inventaire.vol1.entity.Avion;

import jakarta.transaction.Transactional;

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

    @Transactional

    public void updateAvion(int id, Integer capacity, Integer year_manufacture, String model, String immatriculation) {
        Avion avion = avionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("cette avion avec l'id:" + id + "n'existe pas"));

        if (capacity != null && Integer.toString(capacity).length() > 0
                && !Objects.equals(capacity, avion.getCapacity())) {
            avion.setCapacity(capacity);
        }

        if (year_manufacture != null && Integer.toString(year_manufacture).length() > 0
                && !Objects.equals(year_manufacture, avion.getYear_manufacture())) {
            avion.setYear_manufacture(year_manufacture);
        }

        if (model != null && model.length() > 0 && !Objects.equals(model, avion.getModel())) {
            avion.setModel(model);
        }

        if (immatriculation != null && immatriculation.length() > 0
                && Objects.equals(immatriculation, avion.getImmatriculation())) {
            avion.setImmatriculation(immatriculation);
        }
    }
}
