package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import entities.Reservation;
import payload.request.ReservationRequest;
import services.ReservationService;
@ComponentScan
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    
    @PostMapping("/create")
    public ResponseEntity<?> createReservation(@RequestBody ReservationRequest request) {
        try {
            Reservation reservation = reservationService.createReservation(
                request.getVolId(),
                request.getPassagerId(),
                request.getPrixTotal()
            );
            return ResponseEntity.ok(reservation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/cancel/{reservationId}")
    public ResponseEntity<?> cancelReservation(@PathVariable Long reservationId) {
        try {
            reservationService.cancelReservation(reservationId);
            return ResponseEntity.ok("Réservation annulée avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
