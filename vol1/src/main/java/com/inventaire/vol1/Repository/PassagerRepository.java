package com.inventaire.vol1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventaire.vol1.entity.Passager;

@Repository
public interface PassagerRepository extends JpaRepository<Passager, Integer>{
    
    @Query("SELECT s FROM Passager s WHERE nom_complet=?1")
    Optional<Passager> findByName(String name);

}
