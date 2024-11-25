package com.inventaire.vol1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventaire.vol1.entity.Aeroport;

import jakarta.transaction.Transactional;

@Repository
public interface AeroportRepository extends JpaRepository<Aeroport, Integer>{

    @Query("SELECT s FROM Aeroport s WHERE nom_aeroport=?1")
    Optional<Aeroport> findByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Aeroport s WHERE nom_aeroport=?1")
    void deleteByName(String name);
}
