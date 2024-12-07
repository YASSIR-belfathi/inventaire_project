package com.inventaire.vol1.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventaire.vol1.Repository.Membre_equipageRepository;
import com.inventaire.vol1.entity.Membre_equipage;

import jakarta.transaction.Transactional;

@Service
public class Membre_equipageService {
    private final Membre_equipageRepository membre_equipageRepository;

    public Membre_equipageService(Membre_equipageRepository membre_equipageRepository) {
        this.membre_equipageRepository = membre_equipageRepository;
    }

    public List<Membre_equipage> ListMembre() {
        return membre_equipageRepository.findAll();
    }

    public void addMembreEquipage(Membre_equipage membre_equipage) {
        Optional<Membre_equipage> membre_equipageOptional = membre_equipageRepository
                .findByNom_complet(membre_equipage.getNom_complet());

        if (membre_equipageOptional.isPresent()) {
            throw new IllegalStateException("ce membre existe déjà");
        } else {
            System.out.println(membre_equipage);
        }

        membre_equipageRepository.save(membre_equipage);
    }

    public void deleteMembreEquipage(int id) {
        Optional<Membre_equipage> membre_equipageOptional = membre_equipageRepository.findById(id);

        if (membre_equipageOptional.isPresent()) {
            membre_equipageRepository.deleteById(id);
        }

        else {
            throw new IllegalStateException("this member doesn't exists");
        }
    }

    @Transactional
    public void updateMember(int id, String name, String typeMembre, String nationality, String num_licence) {
        Membre_equipage membre_equipage = membre_equipageRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("the member with the id:" + id + "doesn't exists"));

        if (name != null && name.length() > 0 && !Objects.equals(name, membre_equipage.getNom_complet())) {
            membre_equipage.setNom_complet(name);
        }

        if (typeMembre != null && typeMembre.length() > 0
                && !Objects.equals(typeMembre, membre_equipage.getType_membre())) {
            membre_equipage.setType_membre(typeMembre);
        }

        if (nationality != null && nationality.length() > 0
                && !Objects.equals(nationality, membre_equipage.getNationnalite())) {
            membre_equipage.setNationnalite(nationality);
        }

        if (num_licence != null && num_licence.length() > 0
                && !Objects.equals(num_licence, membre_equipage.getNum_licence())) {
            membre_equipage.setNum_licence(num_licence);
        }
    }
}
