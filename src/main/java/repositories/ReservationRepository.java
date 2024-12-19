package repositories;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entities.Reservation;
@Repository

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	@Query("SELECT r FROM Reservation r WHERE r.passager.id = :passengerId AND r.date_reservation < :today")
	List<Reservation> findReservationsHistory(@Param("passengerId") Long passengerId, @Param("today") Date today);

}
