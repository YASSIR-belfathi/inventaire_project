package com.inventaire.vol1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventaire.vol1.entity.Reservation;
import com.inventaire.vol1.services.PassagerService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path="inventaire/vol")
public class PassagerController {
    private final PassagerService passagerService;

    public PassagerController(PassagerService passagerService)
    {
        this.passagerService=passagerService;
    }

    @GetMapping
    public List<Reservation> getMethodName() {
        return passagerService.getReservation();
    }
    
}
