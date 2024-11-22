package com.inventaire.vol1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventaire.vol1.entity.Administrateur;
import com.inventaire.vol1.entity.Utilisateur;
import com.inventaire.vol1.services.AdministrateurService;
import com.inventaire.vol1.services.UtilisateurService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("inventaire")
public class UtilisateurControlleur {
    
    private final UtilisateurService utilisateurService;
    private final AdministrateurService administrateurService;

    public UtilisateurControlleur(UtilisateurService utilisateurService,
    AdministrateurService administrateurService)
    {
        this.administrateurService=administrateurService;
        this.utilisateurService=utilisateurService;
    }

    @GetMapping("utilisateur")
    public List<Utilisateur> getListUtilisateurs()
    {
        return utilisateurService.getListUtilisateur();
    }

    @GetMapping(path = "Administrateur")
    public List<Administrateur> getListAdmin()
    {
        return administrateurService.getListAdmin();
    }

    @PostMapping(path="createAdmin")
    public void addAdmin(@RequestBody Administrateur administrateur)
    {
        administrateurService.addAdmin(administrateur);
    }
}
