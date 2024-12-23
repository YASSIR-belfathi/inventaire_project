package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.vol;
import payload.request.VolRequest;

import java.util.List;

import services.VolService;
@RestController
@RequestMapping("/api/vols")
public class VolController {
    @Autowired
    private VolService volService;

    @GetMapping("/get-vols")
    public List<vol> getAllVols() {
        return volService.getAllVols();
    }
    @PostMapping("/add-vols")
    public ResponseEntity<vol> createVols(@RequestBody VolRequest volRequest) {
    	vol vol = volService.createVols(volRequest);
        return new ResponseEntity<>(vol, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-vol/{id}")
    public ResponseEntity<Void> supprimerVol(@PathVariable Long id) {
    	volService.deleteVolAndReservations(id);
        return ResponseEntity.noContent().build();
    }
}
 















