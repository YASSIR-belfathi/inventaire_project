package com.inventaire.vol1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventaire.vol1.entity.Avion;

import jakarta.transaction.Transactional;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Integer>{
    
    @Query("SELECT s FROM Avion s WHERE immatriculation=?1")
    Optional<Avion> findByImmatriculation(String immatriculation);

    @Modifying
    @Transactional
    @Query("DELETE FROM Avion s WHERE immatriculation=?1")
    void deleteByImmatriculation(String immatriculation);
}
