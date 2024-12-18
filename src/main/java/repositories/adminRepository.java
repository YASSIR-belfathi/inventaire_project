package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.administrateur;
@Repository

public interface adminRepository extends JpaRepository<administrateur, Long>{

    administrateur findByEmail(String email);
}