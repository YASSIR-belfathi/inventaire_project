package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Passager;

import java.util.List;

public interface PassagerService {
     Passager savePassager(Passager passager);
     Passager getPassagerById(int id);
     List<Passager> getAllPassagers();
     void deletePassager(int id);

//Passager savePassager(Passager passager);
//List<Passager> findAllPassagers();
//Optional<Passager> findPassagerById(Long id);
//void deletePassager(Long id);
}
