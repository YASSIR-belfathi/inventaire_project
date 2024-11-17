package com.inventaire.Inventaire_Vols.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventaire.Inventaire_Vols.entities.Administrateur;

public interface AdminRepository extends JpaRepository<Administrateur, Long>{

}