package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Administrateur;
import com.inventaire.Inventaire_Vols.entities.Aeroport;

import java.util.List;

public interface AeroportService {
     Aeroport saveAeroport(Aeroport aeroport);
     List<Aeroport> findAllAeroports();
     Aeroport findAeroportById(Long id);
     void deleteAeroport(Long id);
}
