package com.inventaire.vol1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventaire.vol1.entity.Administrateur;
import com.inventaire.vol1.entity.Aeroport;
import com.inventaire.vol1.entity.Avion;
import com.inventaire.vol1.entity.Utilisateur;
import com.inventaire.vol1.services.AdministrateurService;
import com.inventaire.vol1.services.AeroportService;
import com.inventaire.vol1.services.AvionService;
import com.inventaire.vol1.services.UtilisateurService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("inventaire")
public class AdministrateurControlleur {

    private final UtilisateurService utilisateurService;
    private final AdministrateurService administrateurService;
    private final AeroportService aeroportService;
    private final AvionService avionService;

    public AdministrateurControlleur(UtilisateurService utilisateurService,
            AdministrateurService administrateurService, AeroportService aeroportService,
            AvionService avionService) {
        this.administrateurService = administrateurService;
        this.utilisateurService = utilisateurService;
        this.aeroportService = aeroportService;
        this.avionService = avionService;
    }

    /*
     * +cette méthode va permettre de lister tous les utilisateurs
     * qui existent dans la table utilisateur
     * +le fait de lister les utilisateurs ne sera valable que pour les
     * administrateurs
     */
    @GetMapping(path = "utilisateur")
    public List<Utilisateur> getListUtilisateurs() {
        return utilisateurService.getListUtilisateur();
    }

    /*
     * cette méthode va permettre de lister tous les administrateurs
     */
    @GetMapping(path = "Administrateur")
    public List<Administrateur> getListAdmin() {
        return administrateurService.getListAdmin();
    }

    @GetMapping(path = "Aeroport")
    public List<Aeroport> getListAeroport() {
        return aeroportService.getListAeroport();
    }

    @GetMapping(path = "Avion")
    public List<Avion> getListAvion() {
        return avionService.getListAvion();
    }

    /*
     * cette méthode va permettre créer un utilisateur à partir d'un fichier json
     * qui
     * sera envoyé par le client et qui va contenir l'ensemble des informations
     * nécessaires pour la création des nouveaux utilisateurs.
     */
    @PostMapping(path = "createAdmin")
    public void addAdmin(@RequestBody Administrateur administrateur) {
        administrateurService.addAdmin(administrateur);
    }

    @PostMapping(path = "createAeroport")
    public void addAeroport(@RequestBody Aeroport aeroport) {
        aeroportService.addAeroport(aeroport);
    }

    @PostMapping(path = "createAvion")
    public void addAvion(@RequestBody Avion avion) {
        avionService.addAvion(avion);
    }

    /*
     * cette méthode nous permet de supprimer un administrateur de la table
     * Administrateur et
     * de sa référence dans la table utilisateur
     */
    @DeleteMapping(path = "deleteAdmin/{AdminId}")
    public void deleteAdmin(@PathVariable("AdminId") int Id) {
        administrateurService.deleteAdmin(Id);
    }

    @DeleteMapping(path = "deleteAeroport/{AeroportName}")
    public void deleteAeroport(@PathVariable("AeroportName") String name) {
        aeroportService.deleteAeroport(name);
    }

    @DeleteMapping(path = "deleteAvion/{Immatriculation}")
    public void deleteAvion(@PathVariable("Immatriculation") String Immatriculation) {
        avionService.deleteAvion(Immatriculation);
    }
}
