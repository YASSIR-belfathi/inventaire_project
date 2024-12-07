package com.inventaire.vol1.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventaire.vol1.Repository.AeroportRepository;
import com.inventaire.vol1.entity.Aeroport;

import jakarta.transaction.Transactional;

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

    @Transactional
    public void updateAeroport(int id, String aeroport_IATA, String name, String ville, String pays,
            Integer capacite) {
        Aeroport aeroport = aeroportRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("the aeroport with the id:" + id + "doesn't exists"));

        if (aeroport_IATA != null && aeroport_IATA.length() > 0
                && !Objects.equals(aeroport_IATA, aeroport.getAeroport_IATA())) {
            aeroport.setAeroport_IATA(aeroport_IATA);
        }

        if (name != null && name.length() > 0 && !Objects.equals(name, aeroport.getNom_aeroport())) {
            aeroport.setNom_aeroport(name);
        }

        if (ville != null && ville.length() > 0 && !Objects.equals(ville, aeroport.getVille())) {
            aeroport.setVille(ville);
        }

        if (pays != null && pays.length() > 0 && !Objects.equals(pays, aeroport.getPays())) {
            aeroport.setPays(pays);
        }

        if (capacite != null && Integer.toString(capacite).length() > 0
                && !Objects.equals(capacite, aeroport.getCapacite())) {
            aeroport.setCapacite(capacite);
        }
    }
}
