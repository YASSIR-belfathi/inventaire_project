package controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Aeoroport;
import services.AeroportService;

@RestController
@RequestMapping("/api/admin/aeroports")
public class AeroportController {
    private final AeroportService aeroportService;

    public AeroportController(AeroportService aeroportService) {
        this.aeroportService = aeroportService;
    }

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Aeoroport> creerAeroport(@RequestBody Aeoroport aeroport) {
        return new ResponseEntity<>(aeroportService.creerAeroport(aeroport), HttpStatus.CREATED);
    }

    @GetMapping("/lister")
    public ResponseEntity<List<Aeoroport>> listerAeroports() {
        return ResponseEntity.ok(aeroportService.listerAeroports());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aeoroport> mettreAJourAeroport(@PathVariable Long id,
            @RequestBody Aeoroport detailsAeroport) {
        Aeoroport aeroportMisAJour = aeroportService.mettreAJourAeroport(id, detailsAeroport);
        return ResponseEntity.ok(aeroportMisAJour);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> supprimerAeroport(@PathVariable Long id) {
        aeroportService.supprimerAeroport(id);
        return ResponseEntity.noContent().build();
    }
}
