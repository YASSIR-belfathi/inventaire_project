package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.dto.PassagerDTO;
import com.inventaire.Inventaire_Vols.entities.Passager;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PassagerService {
     PassagerDTO savePassager(PassagerDTO passager);
     PassagerDTO getPassagerById(Long id);
     List<PassagerDTO> getAllPassagers();
     void deletePassager(Long id);

//Passager savePassager(Passager passager);
//List<Passager> findAllPassagers();
//Optional<Passager> findPassagerById(Long id);
//void deletePassager(Long id);
}
