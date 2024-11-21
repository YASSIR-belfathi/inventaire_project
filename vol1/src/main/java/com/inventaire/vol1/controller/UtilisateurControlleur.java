package com.inventaire.vol1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventaire.vol1.entity.Utilisateur;
import com.inventaire.vol1.services.UtilisateurService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("inventaire/utilisateur")
public class UtilisateurControlleur {
    
    private final UtilisateurService utilisateurService;

    public UtilisateurControlleur(UtilisateurService utilisateurService)
    {
        this.utilisateurService=utilisateurService;
    }

    @GetMapping
    public List<Utilisateur> getListUtilisateurs()
    {
        return utilisateurService.getListUtilisateur();
    }

    @PostMapping(path = "create")
    public void addUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.addNewUtilisateur(utilisateur);
    }
    
}
