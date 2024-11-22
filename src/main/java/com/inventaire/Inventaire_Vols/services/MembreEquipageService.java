package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Administrateur;
import com.inventaire.Inventaire_Vols.entities.MembreEquipage;

import java.util.List;

public interface MembreEquipageService {
     MembreEquipage saveMembreEquipage(MembreEquipage membreEquipage);
     List<MembreEquipage> findAllMembresEquipage();
     MembreEquipage findMembreEquipageById(Long id);
     void deleteMembreEquipage(Long id);
}
