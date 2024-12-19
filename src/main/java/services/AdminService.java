package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.*;

import repositories.*;

@Service
public class AdminService {


	private Membre_equipageRepository membre_equipageRepository ;
	private AvionRepository avionRepository;
	private AeoroportRepository aeoroportRepository;
	private VolRepository volRepository ;

    @Autowired
    public AdminService(ReservationRepository reservationRepository, Membre_equipageRepository membre_equipageRepository
    		,AvionRepository avionRepository,AeoroportRepository aeoroportRepository,VolRepository volRepository){
        this.membre_equipageRepository=membre_equipageRepository;
        this.aeoroportRepository=aeoroportRepository;
        this.avionRepository =avionRepository;
        this.volRepository=volRepository;
        
    }
    //methodes de membre equipage
        
    public Membre_equipage addMembre_equipage(Membre_equipage m) {
        return membre_equipageRepository.save(m);
    }
    
    public void removeMembre_equipage(long id) {
    	membre_equipageRepository.deleteById(id);
    }
	
    public Membre_equipage updateReservation(long id, Membre_equipage updatedMembre_equipage) {
        Optional<Membre_equipage> existingMembre_equipage = membre_equipageRepository.findById(id);
    	if(existingMembre_equipage.isPresent()) {
    		Membre_equipage existingMembre_equipage1 = existingMembre_equipage.get();

            existingMembre_equipage1.setNom_complet(updatedMembre_equipage.getNom_complet());
            existingMembre_equipage1.setNum_licence(updatedMembre_equipage.getNum_licence());
            existingMembre_equipage1.setFonction(updatedMembre_equipage.getFonction());
            existingMembre_equipage1.setNationalite(updatedMembre_equipage.getNationalite());
            return membre_equipageRepository.save(existingMembre_equipage1); 
    	}else {
    		throw new IllegalArgumentException("Membre d'equipage avec l'ID " + id + " non trouvée.");
    	}
		  
        }
  //methodes de vol
    public vol addVol(vol v) {
        return volRepository.save(v);
    }
    
    public void removeVol(long id) {
    	volRepository.deleteById(id);
    }
	
    public vol updateVol(long id, vol updatedVol) {
        Optional<vol> existingVol = volRepository.findById(id);
    	if(existingVol.isPresent()) {
    		vol existingVol1 = existingVol.get();

    		existingVol1.setAeroport_arrive(updatedVol.getAeroport_arrive());
    		existingVol1.setAeroport_depart(updatedVol.getAeroport_depart());
    		existingVol1.setDate_vol_depart(updatedVol.getDate_vol_depart());
    		existingVol1.setDate_vol_arrive(updatedVol.getDate_vol_arrive());
    		existingVol1.setPrix_vol(updatedVol.getPrix_vol());

    		existingVol1.setNum_vol(updatedVol.getNum_vol());
    		existingVol1.setVol_IATA(updatedVol.getVol_IATA());
            return volRepository.save(existingVol1); 
    	}else {
    		throw new IllegalArgumentException("Vol avec l'ID " + id + " non trouvée.");
    	}
		  
        }
    //methode de l'aeoroport
    public Aeoroport addAeoroport(Aeoroport a) {
        return aeoroportRepository.save(a);
    }
    
    public void removeAeoroport(long id) {
    	aeoroportRepository.deleteById(id);
    }
	
    public Aeoroport updateAeoroport(long id, Aeoroport updatedAeoroport) {
        Optional<Aeoroport> existingAeoroport = aeoroportRepository.findById(id);
    	if(existingAeoroport.isPresent()) {
    		Aeoroport existingAeoroport1 = existingAeoroport.get();

    		existingAeoroport1.setAeoroport_IATA(updatedAeoroport.getAeoroport_IATA());
    		existingAeoroport1.setNom_aeroport(updatedAeoroport.getNom_aeroport());
    		existingAeoroport1.setCapacite(updatedAeoroport.getCapacite());
    		existingAeoroport1.setPays(updatedAeoroport.getPays());
    		existingAeoroport1.setVille(updatedAeoroport.getVille());
            return aeoroportRepository.save(existingAeoroport1); 
    	}else {
    		throw new IllegalArgumentException("Aeoroport avec l'ID " + id + " non trouvée.");
    	}
		  
        }
    //methode de l'avion
    public Avion addAvion(Avion a) {
        return avionRepository.save(a);
    }
    
    public void removeAvion(long id) {
    	avionRepository.deleteById(id);
    }
	
    public Avion updateAvion(long id, Avion updatedAvion) {
        Optional<Avion> existingAvion = avionRepository.findById(id);
    	if(existingAvion.isPresent()) {
    		Avion existingAvion1 = existingAvion.get();

    		existingAvion1.setType_avion(updatedAvion.getType_avion());
    		existingAvion1.setAnnee_fabrication(updatedAvion.getAnnee_fabrication());
    		existingAvion1.setCapacite(updatedAvion.getCapacite());
    		existingAvion1.setModel(updatedAvion.getModel());
            return avionRepository.save(existingAvion1); 
    	}else {
    		throw new IllegalArgumentException(" l'avion avec l'ID " + id + " non trouvée.");
    	}
		  
        }
    
    

}
