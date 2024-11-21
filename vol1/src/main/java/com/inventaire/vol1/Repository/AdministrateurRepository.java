package com.inventaire.vol1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventaire.vol1.entity.Administrateur;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer>{
    
}
