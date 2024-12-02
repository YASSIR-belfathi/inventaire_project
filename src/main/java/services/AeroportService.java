package services;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


import entities.Aeroport;

import repositories.AeroportRepository;
public class AeroportService {
	@Autowired
	private AeroportRepository aeroportRepository;
	
//liste aeroport	
	 public List<Aeroport> getListAeroport() {
	        return aeroportRepository.findAll();
	    }
	 
	 
//ajouter aeroport
	 public void addAeroport(Aeroport aeroport) {
	        aeroportRepository.save(aeroport);
	    }
	 
//supprimer aeroport
	 public void deleteAeroport(long ID) {
	  
	    	aeroportRepository.deleteById(ID);
	        }
	 
	 
//modifier aeroport
	 public Aeroport updateAeroport(long id, Aeroport NewAeroport) {
		    // Trouver l'aeroport existant par ID
		   Aeroport aeroport = aeroportRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("Aeroport n'exist pas avec l'id : " + id));
		   aeroport.setAeoroport_IATA(NewAeroport.getAeoroport_IATA());
		   aeroport.setCapacite(NewAeroport.getCapacite());
		   aeroport.setNom_aeroport(NewAeroport.getNom_aeroport());
		   aeroport.setPays(NewAeroport.getPays());
		   aeroport.setVille(NewAeroport.getVille());
		   return aeroport;
		    
		}
	    
	    
	    }

