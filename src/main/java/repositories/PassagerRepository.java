package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Passager;
@Repository

public interface PassagerRepository extends JpaRepository<Passager, Long>{

}
