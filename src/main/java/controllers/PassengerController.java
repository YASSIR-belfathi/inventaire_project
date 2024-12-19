package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Reservation;

import org.springframework.http.ResponseEntity;

import services.ReservationService;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/{passengerId}/history")
    public ResponseEntity<List<Reservation>> getReservationHistory(@PathVariable Long passengerId) {
        List<Reservation> history = reservationService.getHistoricalReservations(passengerId);
        return ResponseEntity.ok(history);
    }
}
