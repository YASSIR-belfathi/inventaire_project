package services;

import java.util.List;

import java.util.Optional;

import entities.Administrateur;
import repositories.AdminRepository;

public class AdminService {
	private AdminRepository adminRepository;

	//liste admin
	public List<Administrateur> listAdmin(){
	    return adminRepository.findAll();
	}


	//ajouer nouveau admin
	public Administrateur saveAdmin(Administrateur admin) {
	    return adminRepository.save(admin);
	}
	//supprimer admin
	public void deleteAdmin(long Id){
	    Optional<Administrateur>adminOptional=adminRepository.findById(Id);

	    if(adminOptional.isPresent()){
	        adminRepository.deleteById(Id);
	    }

	    else{
	        throw new IllegalStateException("Aucun administrateur avec l'ID"+Id+"n'exist pas dans la base des donnees");
	    }  
	}

}
