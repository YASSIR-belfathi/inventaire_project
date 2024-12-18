package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Aeroport;

import java.util.List;

@Repository

public interface AeroportRepository extends JpaRepository<Aeroport, Long>{
    List<Aeroport> id(Long id);

}