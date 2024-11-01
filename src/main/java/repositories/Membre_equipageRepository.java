package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Membre_equipage;
@Repository

public interface Membre_equipageRepository extends JpaRepository<Membre_equipage, Long>{

}