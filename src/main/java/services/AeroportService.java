package services;

import java.util.List;

import org.springframework.stereotype.Service;

import entities.Aeoroport;
import jakarta.persistence.EntityNotFoundException;
import repositories.AeoroportRepository;

@Service
public class AeroportService {
    private final AeoroportRepository aeroportRepository;

    public AeroportService(AeoroportRepository aeroportRepository) {
        this.aeroportRepository = aeroportRepository;
    }

    public Aeoroport creerAeroport(Aeoroport aeroport) {
        return aeroportRepository.save(aeroport);
    }

    public List<Aeoroport> listerAeroports() {
        return aeroportRepository.findAll();
    }
    public void supprimerAeroport(Long id) {
        if (!aeroportRepository.existsById(id)) {
            throw new EntityNotFoundException("Aéroport avec l'ID " + id + " non trouvé");
        }
        aeroportRepository.deleteById(id);
    }
    public Aeoroport mettreAJourAeroport(Long id, Aeoroport nouveauAeroport) {
        Aeoroport aeroport = aeroportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aéroport avec l'ID " + id + " non trouvé"));

        // Mettre à jour les champs
        aeroport.setAeoroport_IATA(nouveauAeroport.getAeoroport_IATA());
        aeroport.setNom_aeroport(nouveauAeroport.getNom_aeroport());
        aeroport.setVille(nouveauAeroport.getVille());
        aeroport.setPays(nouveauAeroport.getPays());
        aeroport.setVille(nouveauAeroport.getVille());
        aeroport.setCapacite(nouveauAeroport.getCapacite());

        // Enregistrez les modifications
        return aeroportRepository.save(aeroport);
    }
    
}
