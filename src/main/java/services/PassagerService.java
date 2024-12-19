package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Reservation;
import repositories.*;

@Service
public class PassagerService {


    private ReservationRepository reservationRepository ;

    @Autowired
    public PassagerService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    
    public void removeReservation(long id) {
    	reservationRepository.deleteById(id);
    }
	
    public Reservation updateReservation(long id, Reservation updatedReservation) {
        Optional<Reservation> existingReservation = reservationRepository.findById(id);
    	if(existingReservation.isPresent()) {
            Reservation existingReservation1 = existingReservation.get();

            existingReservation1.setPassager_reservant(updatedReservation.getPassager_reservant());
            existingReservation1.setDate_reservation(updatedReservation.getDate_reservation());
            existingReservation1.setStatus(updatedReservation.getStatus());
            existingReservation1.setPrix_total(updatedReservation.getPrix_total());
            return reservationRepository.save(existingReservation1); 
    	}else {
    		throw new IllegalArgumentException("Reservation avec l'ID " + id + " non trouvée.");
    	}
		  
        }

}
