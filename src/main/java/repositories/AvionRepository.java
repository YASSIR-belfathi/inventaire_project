package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Avion;

public interface AvionRepository extends JpaRepository<Avion, Long>{

}