package com.inventaire.vol1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventaire.vol1.entity.Membre_equipage;

@Repository
public interface Membre_equipageRepository extends JpaRepository<Membre_equipage, Integer> {

    @Query("SELECT s FROM Membre_equipage s WHERE nom_complet=?1")
    Optional<Membre_equipage> findByNom_complet(String nom_complet);
}
