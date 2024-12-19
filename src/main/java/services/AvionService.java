package services;

import java.util.List;

import org.springframework.stereotype.Service;

import entities.Avion;
import jakarta.persistence.EntityNotFoundException;
import repositories.AvionRepository;

@Service
public class AvionService {
    private final AvionRepository avionRepository;

    public AvionService(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }

    public Avion creerAvion(Avion avion) {
        return avionRepository.save(avion);
    }

    public List<Avion> listerAvions() {
        return avionRepository.findAll();
    }
    public void supprimerAvion(Long id) {
        if (!avionRepository.existsById(id)) {
            throw new EntityNotFoundException("Avion avec l'ID " + id + " non trouvé");
        }
        avionRepository.deleteById(id);
    }
    public Avion mettreAJourAvion(Long id, Avion nouveauAvion) {
        Avion avion = avionRepository.findById(id).orElseThrow(() -> 
            new EntityNotFoundException("Avion avec l'ID " + id + " non trouvé"));

        // Mise à jour des informations
        avion.setType_avion(nouveauAvion.getType_avion());
        avion.setCapacite(nouveauAvion.getCapacite());
        avion.setAnnee_fabrication(nouveauAvion.getAnnee_fabrication());
        avion.setModel(nouveauAvion.getModel());

        return avionRepository.save(avion);
    }
    
}
