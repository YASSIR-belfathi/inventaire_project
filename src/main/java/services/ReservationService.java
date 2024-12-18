package services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*modification*/
import services.VolService;
import entities.Passager;
import entities.Reservation;
import entities.vol;
import repositories.PassagerRepository;
import repositories.ReservationRepository;
import repositories.VolRepository;

@Service
@RequiredArgsConstructor
public class ReservationService {
    /*modification*/
    @Autowired
    private VolService volService;


    private final ReservationRepository reservationRepository;

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

    /*modification*/

    public Reservation reserverPlaces(Long volId, String nom, String prenom, int age, int nombrePlaces) {
        vol vol = volService.getVolById(volId).orElseThrow(() -> new RuntimeException("Vol non trouvé"));

        if (vol.getCapacite() - vol.getPlaces_reservees() < nombrePlaces) {
            throw new RuntimeException("Pas assez de places disponibles");
        }

        Reservation reservation = new Reservation();
        reservation.setVol(vol);
        reservation.setPassagerNom(nom);
        reservation.setPassagerPrenom(prenom);
        reservation.setPassagerAge(age);
        reservation.setNombrePlaces(nombrePlaces);

        vol.setPlaces_reservees(vol.getPlaces_reservees() + nombrePlaces);
        /*volService.save(vol);*/

        return reservationRepository.save(reservation);

    }



}
