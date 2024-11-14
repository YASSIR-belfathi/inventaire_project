package com.inventaire.vol1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Membre_equipage extends JpaRepository<Membre_equipage, Integer>{
    
}
