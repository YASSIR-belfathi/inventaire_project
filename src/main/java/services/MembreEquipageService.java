package services;

import entities.Membre_equipage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.Membre_equipageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MembreEquipageService {

    @Autowired
    private Membre_equipageRepository membreEquipageRepository;

    // Créer un membre d'équipage
    public Membre_equipage createMembre(Membre_equipage membre) {
        return membreEquipageRepository.save(membre);
    }

    // Récupérer tous les membres d'équipage
    public List<Membre_equipage> getAllMembres() {
        return membreEquipageRepository.findAll();
    }

    // Récupérer un membre par son ID
    public Optional<Membre_equipage> getMembreById(Long id) {
        return membreEquipageRepository.findById(id);
    }

    // Mettre à jour un membre d'équipage
    public Membre_equipage updateMembre(Long id, Membre_equipage membre) {
        if (membreEquipageRepository.existsById(id)) {
            membre.setId(id);
            return membreEquipageRepository.save(membre);
        } else {
            return null; // Retourner null ou lever une exception
        }
    }

    // Supprimer un membre d'équipage
    public void deleteMembre(Long id) {
        membreEquipageRepository.deleteById(id);
    }
}