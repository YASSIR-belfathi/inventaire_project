package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Administrateur;
import com.inventaire.Inventaire_Vols.repositories.AdministrateurRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class AdministrateurServiceImpl implements AdministrateurService {


    private AdministrateurRepository administrateurRepository;

    @Override
    public Administrateur saveAdministrateur(Administrateur administrateur) {
        Administrateur savedAdministrateur = administrateurRepository.save(administrateur);
        log.info("saveing new Administrateur ");
        return savedAdministrateur;
    }

    @Override
    public List<Administrateur> findAllAdministrateurs() {
        List<Administrateur> listOfAdministrateurs = administrateurRepository.findAll();
        return listOfAdministrateurs;
    }

    @Override
    public Administrateur findAdministrateurById(Long id) {
        Administrateur administrateur =administrateurRepository.findById(id).get();
        return administrateur;
    }

    @Override
    public void deleteAdministrateur(Long id) {
        administrateurRepository.deleteById(id);

    }
}
