package com.inventaire.vol1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventaire.vol1.entity.Passager;
// import com.inventaire.vol1.entity.Reservation;
import com.inventaire.vol1.services.PassagerService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "inventaire")
public class PassagerController {
    private final PassagerService passagerService;

    public PassagerController(PassagerService passagerService) {
        this.passagerService = passagerService;
    }

    @GetMapping("passager")
    public List<Passager> listPassagers() {
        return passagerService.listPassager();
    }

    @PostMapping(path = "createPassager")
    public void addPassager(@RequestBody Passager passager) {
        passagerService.addPassager(passager);
    }

    @DeleteMapping(path = "deletePassager/{PassagerId}")
    public void deletePassager(@PathVariable("PassagerId") int Id) {
        passagerService.deletePassager(Id);
    }

    @PutMapping(path = "updatePassager/{PassagerId}")
    public void updatePassager(@PathVariable("PassagerId") int id, @RequestParam(required = false) String name,
            @RequestParam(required = false) String num_passport, @RequestParam(required = false) String CIN,
            @RequestParam(required = false) String nationality, @RequestParam(required = false) Integer telephone) {
        passagerService.updatePassager(id, name, num_passport, CIN, nationality, telephone);
    }
}
