package com.inventaire.vol1.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventaire.vol1.entity.Administrateur;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer>{
    
    @Query(value="SELECT * FROM administrateur, utilisateur WHERE utilisateur.nom_complet=?1 ", nativeQuery = true)
    Optional<Administrateur> findByNameID(String name);
}
