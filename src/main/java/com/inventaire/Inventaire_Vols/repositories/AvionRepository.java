package com.inventaire.Inventaire_Vols.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventaire.Inventaire_Vols.entities.Avion;

public interface AvionRepository extends JpaRepository<Avion, Long>{

}