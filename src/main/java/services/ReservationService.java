package services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Passager;
import entities.Reservation;
import entities.vol;
import repositories.PassagerRepository;
import repositories.ReservationRepository;
import repositories.VolRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private VolRepository volRepository;

    @Autowired
    private PassagerRepository passagerRepository;

    public Reservation createReservation(Long volId, Long passagerId, int prixTotal) throws Exception {
        vol vol = volRepository.findById(volId)
                .orElseThrow(() -> new Exception("Vol introuvable"));
        Passager passager = passagerRepository.findById(passagerId)
                .orElseThrow(() -> new Exception("Passager introuvable"));

        if (vol.getPlaces_reservees() >= vol.getCapacite()) {
            throw new Exception("Aucune place disponible pour ce vol");}

        vol.setPlaces_reservees(vol.getPlaces_reservees() + 1);
        volRepository.save(vol);
 
        Reservation reservation = new Reservation();
        reservation.setDate_reservation(new Date()); 
        reservation.setStatus("Confirmed"); 
        reservation.setPrix_total(prixTotal);
        reservation.setVol(vol); 
        reservation.setPassager(passager); 
        return reservationRepository.save(reservation);
    }

    public void cancelReservation(Long reservationId) throws Exception {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new Exception("Réservation introuvable"));

        vol vol = reservation.getVol();
        vol.setPlaces_reservees(vol.getPlaces_reservees() - 1);
        volRepository.save(vol);

        reservationRepository.delete(reservation);
    }
    public List<Reservation> getHistoricalReservations(Long passengerId) {
        Date today = new Date();
        return reservationRepository.findReservationsHistory(passengerId, today);
    }
}
