package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public List<vol> getAllVols() {
        return volService.getAllVols();
    }
 /*   @PostMapping
    public ResponseEntity<vol> createFlight(@RequestBody VolRequest volRequest) {
        vol vol = volService.createFlight(volRequest);
        return new ResponseEntity<>(vol, HttpStatus.CREATED);
    }*/
}

