package services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.*;
import payload.request.PassagerRequest;
import repositories.*;

@Service
public class PassagerService {


    
    private PassagerRepository PassagerRepository;
    private ReservationRepository reservationRepository ;
    @Autowired
    public PassagerService(PassagerRepository PassagerRepository,ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
        this.PassagerRepository = PassagerRepository;
    }

    @Transactional
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    
    public void removeReservation(long id) {
    	reservationRepository.deleteById(id);
    }
    public List<PassagerRequest> getAllPassengers() {
        List<Passager> passengers = PassagerRepository.findAll();
        return passengers.stream().map(passenger -> new PassagerRequest(
        	passenger.getId(),
            passenger.getEmail(),
            passenger.getFirst_name(),
            passenger.getLast_name(),
            passenger.getNationalite(),
            0, passenger.getCin(),
            null, passenger.getTelephone(), null
        )).collect(Collectors.toList());
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
