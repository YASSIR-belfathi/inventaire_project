package controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.vol;
import services.VolService;
@ComponentScan
@RestController
public class RechercherVolController {
	private VolService volService;
	@Autowired
    public void setVolService(VolService volService) {
        this.volService = volService;
    }
	@GetMapping("/search-flights")
	public List<vol> searchFlights(Model model, 
	                            @RequestParam String aeroport_depart, 
	                            @RequestParam String aeroport_arrive, 
	                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date_vol_depart,
	                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date_vol_arrive) {
	    // Logique pour récupérer les vols avec les paramètres reçus
		System.out.println("i am here now .......");
	    List<vol> flights = volService.searchVols(aeroport_depart,aeroport_arrive,date_vol_depart,date_vol_arrive);
	    return flights;  
	}


}
