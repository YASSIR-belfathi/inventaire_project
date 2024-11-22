package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Administrateur;
import com.inventaire.Inventaire_Vols.entities.Passager;

import java.util.List;
import java.util.Optional;

public interface AdministrateurService {
     Administrateur saveAdministrateur(Administrateur administrateur);
     List<Administrateur> findAllAdministrateurs();
     Administrateur findAdministrateurById(Long id);
     void deleteAdministrateur(Long id);
}
