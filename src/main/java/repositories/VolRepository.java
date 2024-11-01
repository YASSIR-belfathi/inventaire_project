package repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.vol;
@Repository

public interface VolRepository extends JpaRepository<vol, Long>{
	
}
