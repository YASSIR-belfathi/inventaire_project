package controllers;

import entities.Aeroport;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AeroportService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aeroport")
public class AeroportController {

    @Autowired
    private AeroportService aeroportService;

    // Créer un aéroport
    @PostMapping("/create")
    public ResponseEntity<Aeroport> createAeroport(@RequestBody @Valid Aeroport aeroport) {
        Aeroport createdAeroport = aeroportService.createAeroport(aeroport);
        return new ResponseEntity<>(createdAeroport, HttpStatus.CREATED);
    }

    // Récupérer la liste des aéroports
    @GetMapping("/list")
    public List<Aeroport> getAllAeroports() {
        return aeroportService.getAllAeroports();
    }

    // Récupérer un aéroport par ID
    @GetMapping("/{id}")
    public ResponseEntity<Aeroport> getAeroportById(@PathVariable Long id) {
        Optional<Aeroport> aeroport = aeroportService.getAeroportById(id);
        return aeroport.map(aeroport1 -> new ResponseEntity<>(aeroport1, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Supprimer un aéroport par ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteAeroport(@PathVariable Long id) {
        aeroportService.deleteAeroport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Mettre à jour un aéroport
    @PutMapping("MiseAjour/{id}")
    public ResponseEntity<Aeroport> updateAeroport(@PathVariable Long id, @RequestBody @Valid Aeroport updatedAeroport) {
        try {
            Aeroport updated = aeroportService.updateAeroport(id, updatedAeroport);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}