package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Aeoroport;
@Repository

public interface AeoroportRepository extends JpaRepository<Aeoroport, Long>{

}