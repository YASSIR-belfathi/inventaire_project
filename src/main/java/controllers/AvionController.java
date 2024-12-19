package controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Aeoroport;
import entities.Avion;
import services.AvionService;

@RestController
@RequestMapping("/api/admin/avions")
public class AvionController {
    private final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @PostMapping("/create")
    public ResponseEntity<Avion> creerAvion(@RequestBody Avion avion) {
        return new ResponseEntity<>(avionService.creerAvion(avion), HttpStatus.CREATED);
    }

    @GetMapping("/lister")
    public ResponseEntity<List<Avion>> listerAvions() {
        return ResponseEntity.ok(avionService.listerAvions());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Avion> mettreAJourAvion(@PathVariable Long id, @RequestBody Avion nouveauAvion) {
        Avion aeroportMisAJour = avionService.mettreAJourAvion(id, nouveauAvion);
        return ResponseEntity.ok(aeroportMisAJour);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> supprimerAvion(@PathVariable Long id) {
    	avionService.supprimerAvion(id);
        return ResponseEntity.noContent().build();
    }
}

