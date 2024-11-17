package com.inventaire.Inventaire_Vols.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.inventaire.Inventaire_Vols.entities.Vol;
public interface VolRepository extends JpaRepository<Vol, Long>{
	
}
