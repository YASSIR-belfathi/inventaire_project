package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Avion;
import repositories.AvionRepository;

public class AvionService {
	@Autowired
	private AvionRepository avionRepository;
	
//liste avion	
	 public List<Avion> getListAvion() {
	        return avionRepository.findAll();
	    }
	 
	 
//ajouter avion
	 public void addAvion(Avion avion) {
	        avionRepository.save(avion);
	    }
	 
//supprimer avion
	 public void deleteAvion(long ID) {
	  
	    	avionRepository.deleteById(ID);
	        }
	 
	 
//modifier avion
	 public Avion updateAvion(long id, Avion NewAvion) {
		    // Trouver l'avion existant par ID
		    Avion avion = avionRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("aucun avion avec l'id : " + id));
		   avion.setAnnee_fabrication(NewAvion.getAnnee_fabrication());
		   avion.setCapacite(NewAvion.getCapacite());
		   avion.setModel(NewAvion.getModel());
		   avion.setType_avion(NewAvion.getType_avion());
		   
		   return avion;
		    
		}
	    
}
