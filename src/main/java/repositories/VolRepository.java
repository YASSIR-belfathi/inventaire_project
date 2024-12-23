package repositories;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entities.vol;
import jakarta.transaction.Transactional;
@Repository

public interface VolRepository extends JpaRepository<vol, Long>{
	@Query("SELECT v FROM vol v WHERE v.aeroport_depart = :aeroport_depart " +
	           "AND v.aeroport_arrive = :aeroport_arrive " +
	           "AND v.date_vol_depart = :date_vol_depart " + 
	           "AND v.date_vol_arrive = :date_vol_arrive "
	           )
	    List<vol> findvolByAirportsAndDate(
	        String aeroport_depart, String aeroport_arrive, 
	        Date date_vol_depart,Date date_vol_arrive);
	    
	    @Modifying
	    @Transactional
	    @Query("DELETE FROM Reservation r WHERE r.vol.id = :volId")
	    void deleteReservationsByVolId(@Param("volId") Long volId);
	    
	    @Modifying
	    @Transactional
	    @Query("DELETE FROM vol v WHERE v.id = :volId")
	    void deleteVolById(@Param("volId") Long volId);
}
