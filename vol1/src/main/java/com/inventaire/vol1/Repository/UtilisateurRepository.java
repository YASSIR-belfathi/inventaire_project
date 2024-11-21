package com.inventaire.vol1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventaire.vol1.entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

    @Query("SELECT s FROM Utilisateur s WHERE nom_complet=?1")
    Optional<Utilisateur> findUtilisateurByNom(String Nom_complet);
}
