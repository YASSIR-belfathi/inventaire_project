package com.inventaire.vol1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventaire.vol1.entity.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Integer>{
    
}
