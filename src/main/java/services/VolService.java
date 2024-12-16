package services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import entities.vol;
import repositories.VolRepository;
@Component
@Service
public class VolService {
	@Autowired
    private VolRepository VolRepository;
	public List<vol> searchVols(String aeroport_depart, String aeroport_arrive, 
	         Date date_vol) {
		return VolRepository.findvolByAirportsAndDate(aeroport_depart, aeroport_arrive, date_vol);
}
	 @Autowired

	    public List<vol> getAllVols() {
	        return VolRepository.findAll();
	    }

}
