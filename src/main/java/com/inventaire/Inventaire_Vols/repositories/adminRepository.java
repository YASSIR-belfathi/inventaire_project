package com.inventaire.Inventaire_Vols.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventaire.Inventaire_Vols.entities.administrateur;

public interface adminRepository extends JpaRepository<administrateur, Long>{

}