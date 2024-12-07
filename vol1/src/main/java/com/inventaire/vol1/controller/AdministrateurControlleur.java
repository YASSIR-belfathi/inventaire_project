package com.inventaire.vol1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventaire.vol1.entity.Administrateur;
import com.inventaire.vol1.entity.Aeroport;
import com.inventaire.vol1.entity.Avion;
import com.inventaire.vol1.entity.Membre_equipage;
import com.inventaire.vol1.entity.Utilisateur;
import com.inventaire.vol1.services.AdministrateurService;
import com.inventaire.vol1.services.AeroportService;
import com.inventaire.vol1.services.AvionService;
import com.inventaire.vol1.services.Membre_equipageService;
import com.inventaire.vol1.services.UtilisateurService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("inventaire")
public class AdministrateurControlleur {

    private final UtilisateurService utilisateurService;
    private final AdministrateurService administrateurService;
    private final AeroportService aeroportService;
    private final AvionService avionService;
    private final Membre_equipageService membre_equipageService;

    public AdministrateurControlleur(UtilisateurService utilisateurService,
            AdministrateurService administrateurService, AeroportService aeroportService,
            AvionService avionService, Membre_equipageService membre_equipageService) {
        this.administrateurService = administrateurService;
        this.utilisateurService = utilisateurService;
        this.aeroportService = aeroportService;
        this.avionService = avionService;
        this.membre_equipageService = membre_equipageService;
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

    @GetMapping(path = "Membre_equipage")
    public List<Membre_equipage> getListMembre_equipages() {
        return membre_equipageService.ListMembre();
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

    @PostMapping(path = "createMember")
    public void addMember(@RequestBody Membre_equipage membre_equipage) {
        membre_equipageService.addMembreEquipage(membre_equipage);
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

    @DeleteMapping(path = "deleteAvion/{Immatricu}")
    public void deleteAvion(@PathVariable("Immatricu") String Immatriculation) {
        avionService.deleteAvion(Immatriculation);
    }

    @DeleteMapping(path = "deleteMember/{MemberID}")
    public void deleteMember(@PathVariable("MemberID") int id) {
        membre_equipageService.deleteMembreEquipage(id);
    }

    // Partie de modification

    @PutMapping(path = "updateAdmin/{AdminId}")
    public void updateAdmin(@PathVariable("AdminId") int id, @RequestParam(required = false) String name,
            @RequestParam(required = false) String email, @RequestParam(required = false) String password,
            @RequestParam(required = false) Integer telephone, @RequestParam(required = false) String postTravail) {
        administrateurService.updateAdmin(id, name, email, password, telephone, postTravail);
    }

    @PutMapping(path = "updateAeroport/{AeroportId}")
    public void updateAeroport(@PathVariable("AeroportId") int id, @RequestParam(required = false) String aeroport_IATA,
            @RequestParam(required = false) String name, @RequestParam(required = false) String ville,
            @RequestParam(required = false) String pays, @RequestParam(required = false) Integer capacite) {
        aeroportService.updateAeroport(id, aeroport_IATA, name, ville, pays, capacite);
    }

    @PutMapping(path = "updateAvion/{AvionId}")
    public void updateAvion(@PathVariable("AvionId") int id, @RequestParam(required = false) Integer capacity,
            @RequestParam(required = false) Integer year_manufacture, @RequestParam(required = false) String model,
            @RequestParam(required = false) String immatriculation) {
        avionService.updateAvion(id, capacity, year_manufacture, model, immatriculation);
    }

    @PutMapping(path = "updateMember/{MemberId}")
    public void updateMember(@PathVariable("MemberId") int id, @RequestParam(required = false) String name,
            @RequestParam(required = false) String typeMember, @RequestParam(required = false) String nationality,
            @RequestParam(required = false) String num_licence) {
        membre_equipageService.updateMember(id, name, typeMember, nationality, num_licence);
    }
}
