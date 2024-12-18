package services;

import entities.Avion;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AvionRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AvionService {

    // la creation de l'avion
    @Autowired
    private AvionRepository avionRepository;

    public Avion createAvion(Avion avion) {
        return avionRepository.save(avion);}

    public List<Avion> getAllAvions() {
        return avionRepository.findAll(); }

    public Avion getAvionById(Long id) {
        return avionRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteAvion(Long id) {
        if (avionRepository.existsById(id)) {
            avionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Avion non trouvé");
        }
    }

    public Avion updateAvion(Long id, Avion avionDto) {
        // Recherche de l'avion par son ID
        Optional<Avion> existingAvion = avionRepository.findById(id);

        if (existingAvion.isPresent()) {
            Avion avionToUpdate = existingAvion.get();

            // Mise à jour des champs de l'avion avec les nouvelles données
            avionToUpdate.setType_avion(avionDto.getType_avion());
            avionToUpdate.setCapacite(avionDto.getCapacite());
            avionToUpdate.setAnnee_fabrication(avionDto.getAnnee_fabrication());
            avionToUpdate.setModel(avionDto.getModel());

            // Sauvegarde de l'avion mis à jour
            return avionRepository.save(avionToUpdate);
        } else {
            throw new RuntimeException("Avion avec l'ID " + id + " non trouvé");
        }
    }
}





