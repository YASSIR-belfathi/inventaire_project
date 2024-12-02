package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import entities.Vol;
import repositories.VolRepository; 

@Service
public class VolService {
	
@Autowired
private VolRepository volRepository;
	

//list vols
 public List<Vol> getAllBooks() {
	        return volRepository.findAll();
	    }
	
 
 
 
public List<Vol> rechercherVol(String aeroportDepart, String aeroportArrive, Date dateDepart, Date dateArrive, int nbrPersonne) {
	        return volRepository.findByAeroportDepartAndAeroportArriveAndDateDepartAndDateArrive(
	                aeroportDepart,
	                aeroportArrive,
	                dateDepart,
	                dateArrive);
	    }
	
	

}
