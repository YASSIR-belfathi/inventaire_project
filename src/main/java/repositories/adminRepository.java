package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.administrateur;

public interface adminRepository extends JpaRepository<administrateur, Long>{

}