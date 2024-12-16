package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.vol;

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
}

