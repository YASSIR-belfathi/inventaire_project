package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.dto.PassagerDTO;
import com.inventaire.Inventaire_Vols.entities.Passager;
import com.inventaire.Inventaire_Vols.mappers.PassagerMapperImpl;
import com.inventaire.Inventaire_Vols.repositories.PassagerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PassagerServiceImpl implements PassagerService {
    private PassagerRepository passagerRepository;
    private PassagerMapperImpl passagerMapper;
    @Override
    public PassagerDTO savePassager(PassagerDTO passagerDTO) {
        Passager passager = passagerMapper.fromPassagerDTO(passagerDTO);
        Passager savedPassager = passagerRepository.save(passager);
        return passagerMapper.fromPassager(savedPassager);
    }

    @Override
    public PassagerDTO getPassagerById(Long id) {
        Passager passager= passagerRepository.findById(id).orElse(null);
        return passagerMapper.fromPassager(passager);
    }

    @Override
    public List<PassagerDTO> getAllPassagers() {
        List<Passager> passagers = passagerRepository.findAll();
        //        List<PassagerDTO> passagerDTOs = new ArrayList<>();
//        for (Passager passager : passagers) {
//            PassagerDTO passagerDTO = passagerMapper.fromPassager(passager);
//            passagerDTOs.add(passagerDTO);
//        }
        return passagers.stream().map(passager -> passagerMapper.fromPassager(passager)).toList();
    }

    @Override
    public void deletePassager(Long id) {
        passagerRepository.deleteById(id);
    }


}
