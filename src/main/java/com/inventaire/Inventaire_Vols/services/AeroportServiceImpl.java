package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Aeroport;
import com.inventaire.Inventaire_Vols.repositories.AeoroportRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class AeroportServiceImpl implements AeroportService {
    private AeoroportRepository aeoroportRepository;
    @Override
    public Aeroport saveAeroport(Aeroport aeroport) {
        Aeroport savedAeroport = aeoroportRepository.save(aeroport);
        return savedAeroport;
    }

    @Override
    public List<Aeroport> findAllAeroports() {
        List<Aeroport> ListOfAeroports = aeoroportRepository.findAll();
        return ListOfAeroports;
    }

    @Override
    public Aeroport findAeroportById(Long id) {
        Aeroport aeroport =aeoroportRepository.findById(id).orElse(null);
        return aeroport;
    }

    @Override
    public void deleteAeroport(Long id) {
        aeoroportRepository.deleteById(id);
    }
}
