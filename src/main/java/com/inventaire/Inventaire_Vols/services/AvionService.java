package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Administrateur;
import com.inventaire.Inventaire_Vols.entities.Avion;

import java.util.List;
import java.util.Optional;

public interface AvionService {
     Avion saveAvion(Avion avion);
     List<Avion> findAllAvions();
     Avion findAvionById(Long id);
     void deleteAvion(Long id);
}
