package controllers;

import entities.Avion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.AvionRepository;
import services.AvionService;

import java.util.List;

@RestController
@RequestMapping("/avion")
public class AvionController {

    @Autowired
    private AvionService avionService;

    @Autowired
    private AvionRepository avionRepository;

    // Endpoint pour créer un avion
    @PostMapping("/create")
    public ResponseEntity<Avion> createAvion(@RequestBody @Valid Avion avion) {
        Avion createdAvion = avionService.createAvion(avion);
        return new ResponseEntity<>(createdAvion, HttpStatus.CREATED);
    }

    // Obtenir tous les avions
    @GetMapping("list")
    public List<Avion> getAllAvions() {
        return avionService.getAllAvions();
    }

    // Obtenir un avion par ID
    @GetMapping("/{id}")
    public ResponseEntity<Avion> getAvionById(@PathVariable Long id) {
        Avion avion = avionService.getAvionById(id);
        if (avion != null) {
            return new ResponseEntity<>(avion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un avion par ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteAvion(@PathVariable Long id) {
        try {
            avionService.deleteAvion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Code 204 No Content
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Code 404 Not Found
        }
    }

    // Mise à jour d'un avion
    @PutMapping("MiseAjour/{id}")
    public ResponseEntity<?> updateAvion(@PathVariable Long id, @RequestBody Avion updatedAvion) {
        // Vérification de l'existence de l'avion
        if (!avionRepository.existsById(id)) {
            return ResponseEntity.status(404).body("Avion non trouvé");
        }

        // Récupérer l'avion existant
        Avion avion = avionRepository.findById(id).orElseThrow(() -> new RuntimeException("Avion non trouvé"));

        // Mettre à jour les champs de l'avion
        avion.setType_avion(updatedAvion.getType_avion());
        avion.setCapacite(updatedAvion.getCapacite());
        avion.setAnnee_fabrication(updatedAvion.getAnnee_fabrication());
        avion.setModel(updatedAvion.getModel());

        // Sauvegarder l'avion mis à jour
        avionRepository.save(avion);

        return ResponseEntity.ok("Avion mis à jour avec succès");
    }
}
