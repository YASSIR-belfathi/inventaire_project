package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Administrateur;
import com.inventaire.Inventaire_Vols.entities.Vol;

import java.util.Date;
import java.util.List;

public interface VolService {
     Vol saveVol(Vol vol);
     List<Vol> findAllVols();
     Vol findVolById(Long id);
     void deleteVol(Long id);
     List<Vol> findVolsByAeroportDepartAndArrive(String depart, String arrive);
     List<Vol> findVolsByDate(Date date);
}
