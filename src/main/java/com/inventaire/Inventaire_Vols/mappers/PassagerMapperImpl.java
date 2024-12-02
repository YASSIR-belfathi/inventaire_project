package com.inventaire.Inventaire_Vols.mappers;

import com.inventaire.Inventaire_Vols.dto.PassagerDTO;
import com.inventaire.Inventaire_Vols.entities.Passager;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PassagerMapperImpl {
    public PassagerDTO fromPassager(Passager passager) {
        PassagerDTO passagerDTO = new PassagerDTO();
        BeanUtils.copyProperties(passager, passagerDTO);
        return passagerDTO;
    }
    public Passager fromPassagerDTO(PassagerDTO passagerDTO) {
        Passager passager = new Passager();
        BeanUtils.copyProperties(passagerDTO, passager);
        return passager;
    }

}
