package com.inventaire.vol1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventaire.vol1.Repository.AeroportRepository;
import com.inventaire.vol1.entity.Aeroport;

@Service
public class AeroportService {
    public final AeroportRepository aeroportRepository;

    public AeroportService(AeroportRepository aeroportRepository) {
        this.aeroportRepository = aeroportRepository;
    }

    public List<Aeroport> getListAeroport() {
        return aeroportRepository.findAll();
    }

    public void addAeroport(Aeroport aeroport) {
        Optional<Aeroport> aeroportOptional = aeroportRepository.findByName(aeroport.getNom_aeroport());

        if (aeroportOptional.isPresent()) {
            throw new IllegalStateException("cet aeroport exist déjà");
        } else {
            System.out.println(aeroport);
        }

        aeroportRepository.save(aeroport);
    }

    public void deleteAeroport(String name) {
        Optional<Aeroport> aeroportOptional = aeroportRepository.findByName(name);

        if (aeroportOptional.isPresent()) {
            aeroportRepository.deleteByName(name);
        } else {
            throw new IllegalStateException("cet aeroport n'existe pas");
        }
    }
}
