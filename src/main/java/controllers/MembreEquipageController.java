package controllers;

import entities.Membre_equipage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.Membre_equipageRepository;
import services.MembreEquipageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/membres")
public class MembreEquipageController {

    @Autowired
    private MembreEquipageService membreEquipageService;

    // Créer un membre d'équipage
    @PostMapping("/create")
    public ResponseEntity<Membre_equipage> createMembre(@RequestBody Membre_equipage membre) {
        Membre_equipage createdMembre = membreEquipageService.createMembre(membre);
        return new ResponseEntity<>(createdMembre, HttpStatus.CREATED);
    }

    // Récupérer tous les membres d'équipage
    @GetMapping("/list")
    public ResponseEntity<List<Membre_equipage>> getAllMembres() {
        List<Membre_equipage> membres = membreEquipageService.getAllMembres();
        return new ResponseEntity<>(membres, HttpStatus.OK);
    }

    // Récupérer un membre d'équipage par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Membre_equipage> getMembreById(@PathVariable Long id) {
        Optional<Membre_equipage> membre = membreEquipageService.getMembreById(id);
        return membre.map(membre1 -> new ResponseEntity<>(membre1, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Mettre à jour un membre d'équipage
    @PutMapping("update/{id}")
    public ResponseEntity<Membre_equipage> updateMembre(@PathVariable Long id, @RequestBody Membre_equipage membre) {
        Membre_equipage updatedMembre = membreEquipageService.updateMembre(id, membre);
        if (updatedMembre != null) {
            return new ResponseEntity<>(updatedMembre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un membre d'équipage
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteMembre(@PathVariable Long id) {
        membreEquipageService.deleteMembre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}