package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.MembreEquipage;
import com.inventaire.Inventaire_Vols.repositories.MembreEquipageRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor

public class MembreEquipageServiceImpl implements MembreEquipageService {
    private MembreEquipageRepository membreEquipageRepository;
    @Override
    public MembreEquipage saveMembreEquipage(MembreEquipage membreEquipage) {
        MembreEquipage membreEquipageSaved = membreEquipageRepository.save(membreEquipage);
        return membreEquipageSaved;
    }

    @Override
    public List<MembreEquipage> findAllMembresEquipage() {
        List<MembreEquipage> membreEquipages = membreEquipageRepository.findAll();
        return membreEquipages;
    }

    @Override
    public MembreEquipage findMembreEquipageById(Long id) {
        MembreEquipage membreEquipage = membreEquipageRepository.getReferenceById(id);
        return membreEquipage;
    }

    @Override
    public void deleteMembreEquipage(Long id) {
        membreEquipageRepository.deleteById(id);
    }
}
