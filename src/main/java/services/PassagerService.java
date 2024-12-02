package services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import entities.Passager;
import repositories.PassagerRepository;
@Service
public class PassagerService {

@Autowired
private PassagerRepository passagerRepository;

//liste passager
public List<Passager> listPassager(){
    return passagerRepository.findAll();
}


//ajouer nouveau passager
public Passager savePassager(Passager passager) {
    return passagerRepository.save(passager);
}
//supprimer passager
public void deletePassager(long Id){
    Optional<Passager> passagerOptional=passagerRepository.findById(Id);

    if(passagerOptional.isPresent()){
        passagerRepository.deleteById(Id);
    }

    else{
        throw new IllegalStateException("Aucun passager avec l'ID"+Id+"n'exist pas dans la base des donnees");
    }  
}
}
