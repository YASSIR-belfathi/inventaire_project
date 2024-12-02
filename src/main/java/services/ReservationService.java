package services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import repositories.PassagerRepository;
import repositories.ReservationRepository;
import entities.Passager;
import entities.Reservation;



public class ReservationService {
@Autowired
private ReservationRepository reservationRepository;
@Autowired
private PassagerRepository  passagerRepository;


//ajouter reservation
public Reservation saveReservation(Reservation reservation) {
return reservationRepository.save(reservation);
	    }

//liste reservation
public List<Reservation> getListReservation() {
    return reservationRepository.findAll();
}

//  modifier reservation
public Reservation updateReservation(long id, Reservation NewReservation) {
    // Trouver la réservation existante par ID
    Reservation reservation = reservationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reservation n'exist pas avec l'id: " + id));
    Passager passager =reservation.getPassager();
     // Mettre à jour les détails du passager(nom complet) 
    passager.setNom_complet(NewReservation.getPassager().getNom_complet());
    passagerRepository.save(passager);
    return reservationRepository.save(reservation);
    
}


//supprimer reservation
public void deleteResarvation(long id) {
	reservationRepository.deleteById(id);
}
}


