package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Avion;

import java.util.List;

@Repository

public interface AvionRepository extends JpaRepository<Avion, Long>{

    List<Avion> id(Long id);
}