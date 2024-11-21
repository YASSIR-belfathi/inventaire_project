package com.inventaire.vol1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventaire.vol1.entity.Membre_equipage;

@Repository
public interface Membre_equipageRepository extends JpaRepository<Membre_equipage, Integer>{
    
}
