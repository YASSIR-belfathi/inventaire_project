package com.inventaire.Inventaire_Vols.web;

import com.inventaire.Inventaire_Vols.dto.PassagerDTO;
import com.inventaire.Inventaire_Vols.entities.Passager;
import com.inventaire.Inventaire_Vols.services.PassagerService;
import com.inventaire.Inventaire_Vols.services.PassagerServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
//@RequestMapping("inventaire")

public class PassagerrestController {

    private final PassagerServiceImpl passagerServiceImpl;
   // private final PassagerService passagerService;
    @GetMapping("/passagers")
    public List<PassagerDTO> passagers() {
        return passagerServiceImpl.getAllPassagers();
    }
    @GetMapping("/passagers/{id}")
    public PassagerDTO getPassager(@PathVariable(name = "id") Long id) {
        return passagerServiceImpl.getPassagerById(id);
    }
    @PostMapping("/passagers")
    public PassagerDTO savePassager(@RequestBody PassagerDTO passagerDTO) {
        log.info("Requête POST reçue avec les données : {}", passagerDTO);
        PassagerDTO result = passagerServiceImpl.savePassager(passagerDTO);
        log.info("Passager enregistré : {}", result);
        return result;
    }


}
