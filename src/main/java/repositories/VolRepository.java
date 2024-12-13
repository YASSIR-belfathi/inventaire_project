package repositories;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import entities.vol;
@Repository

public interface VolRepository extends JpaRepository<vol, Long>{
	@Query("SELECT v FROM vol v WHERE v.aeroport_depart = :aeroport_depart " +
	           "AND v.aeroport_arrive = :aeroport_arrive " +
	           "AND v.date_vol = :date_vol ")
	    List<vol> findvolByAirportsAndDate(
	        String aeroport_depart, String aeroport_arrive, 
	         Date date_vol);
}
