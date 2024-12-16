package services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import entities.vol;
import payload.request.VolRequest;
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
        return VolRepository.findAll();}
    public vol createVols(VolRequest VolRequest) {
        vol vol = new vol();
        vol.setNum_vol(VolRequest.getNum_vol());
        vol.setVol_IATA(VolRequest.getVol_IATA());
        vol.setDate_vol_depart(VolRequest.getDate_vol_depart());
        vol.setDate_vol_arrive(VolRequest.getDate_vol_arrive());
        vol.setPrix_vol(VolRequest.getPrix_vol());
        vol.setAeroport_depart(VolRequest.getAeroport_depart());
        vol.setAeroport_arrive(VolRequest.getAeroport_arrive());
        vol.setCapacite(VolRequest.getCapacite());
        return VolRepository.save(vol);
    }
}
