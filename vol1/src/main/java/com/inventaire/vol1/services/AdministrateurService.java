package com.inventaire.vol1.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventaire.vol1.Repository.AdministrateurRepository;
import com.inventaire.vol1.entity.Administrateur;

import jakarta.transaction.Transactional;

@Service
public class AdministrateurService {
    private final AdministrateurRepository administrateurRepository;

    public AdministrateurService(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    public List<Administrateur> getListAdmin() {
        return administrateurRepository.findAll();
    }

    public void addAdmin(Administrateur admin) {
        Optional<Administrateur> administrateurOptional = administrateurRepository.findByNameID(admin.getNom_complet());

        if (administrateurOptional.isPresent()) {
            throw new IllegalStateException("cette utilisateur est déjà un administrateur");
        } else {
            System.out.println(admin);
        }
        administrateurRepository.save(admin);
    }

    public void deleteAdmin(int Id) {
        Optional<Administrateur> administrateurOptional = administrateurRepository.findById(Id);

        if (!administrateurOptional.isPresent()) {
            throw new IllegalStateException("cette administrateur n'existe pas");
        }
        administrateurRepository.deleteById(Id);
    }

    @Transactional
    public void updateAdmin(int id, String name, String email, String password, Integer telephone,
            String posteTravail) {
        Administrateur administrateur = administrateurRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("administrator with id" + id + "don'exists"));

        if (name != null && name.length() > 0 && !Objects.equals(name, administrateur.getNom_complet())) {
            administrateur.setNom_complet(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(email, administrateur.getEmail())) {
            administrateur.setEmail(email);
        }

        if (password != null && password.length() > 0 && !Objects.equals(password, administrateur.getPassword())) {
            administrateur.setPassword(password);
        }

        if (telephone != null && Integer.toString(telephone).length() > 0
                && !Objects.equals(telephone, administrateur.getTelephone())) {
            administrateur.setTelephone(telephone);
        }

        if (posteTravail != null && posteTravail.length() > 0
                && !Objects.equals(posteTravail, administrateur.getPoste_travail())) {
            administrateur.setPoste_travail(posteTravail);
        }

    }
}
