package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Long>{

}
