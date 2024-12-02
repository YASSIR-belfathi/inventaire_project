package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Avion;
import com.inventaire.Inventaire_Vols.repositories.AvionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class AvionServiceImpl implements AvionService {
    private AvionRepository avionRepository;
    @Override
    public Avion saveAvion(Avion avion) {
        Avion savedAvion = avionRepository.save(avion);
        return savedAvion;
    }

    @Override
    public List<Avion> findAllAvions() {
        List<Avion> avions = avionRepository.findAll();
        return avions;
    }

    @Override
    public Avion findAvionById(Long id) {
        Avion avion= avionRepository.findById(id).get();
        return avion;
    }

    @Override
    public void deleteAvion(Long id) {
        avionRepository.deleteById(id);
    }
}
