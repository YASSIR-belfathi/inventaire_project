package services;

import entities.Aeroport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import repositories.AeroportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AeroportService {
    @Autowired
    private AeroportRepository aeroportRepository;

    public Aeroport createAeroport(Aeroport aeroport) {
        return aeroportRepository.save(aeroport);
    }

    public List<Aeroport> getAllAeroports() {
        return aeroportRepository.findAll();
    }

    public Optional<Aeroport> getAeroportById(Long id) {
        return aeroportRepository.findById(id);
    }

    public void deleteAeroport(Long id) {
        // Vérifier si l'aéroport existe avant de tenter de le supprimer
        if (aeroportRepository.existsById(id)) {
            try {
                aeroportRepository.deleteById(id);
            } catch (EmptyResultDataAccessException e) {
                // Log de l'erreur ou autre gestion personnalisée
                throw new RuntimeException("Erreur lors de la suppression de l'aéroport avec ID " + id, e);
            }
        } else {
            // L'aéroport n'existe pas, on lance une exception personnalisée
            throw new RuntimeException("Aéroport avec ID " + id + " non trouvé");
        }
    }

    public Aeroport updateAeroport(Long id, Aeroport updatedAeroport) {
        if (aeroportRepository.existsById(id)) {
            updatedAeroport.setId(id);
            return aeroportRepository.save(updatedAeroport);
        } else {
            throw new RuntimeException("Aéroport non trouvé");
        }
    }
}
