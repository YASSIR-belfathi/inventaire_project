package com.inventaire.vol1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventaire.vol1.Repository.AdministrateurRepository;
import com.inventaire.vol1.entity.Administrateur;

@Service
public class AdministrateurService {
    private final AdministrateurRepository administrateurRepository;

    public AdministrateurService(AdministrateurRepository administrateurRepository)
    {
        this.administrateurRepository=administrateurRepository;
    }

    public List<Administrateur> getListAdmin()
    {
        return administrateurRepository.findAll();
    }

    public void addAdmin(Administrateur admin){
        Optional<Administrateur> administrateurOptional=administrateurRepository.findByNameID(admin.getNom_complet());

        if(administrateurOptional.isPresent())
        {
            throw new IllegalStateException("cette utilisateur est déjà un administrateur");
        }
        else {
            System.out.println(admin);
        }
        administrateurRepository.save(admin);
    }

    public void deleteAdmin(int Id)
    {
        Optional<Administrateur> administrateurOptional=administrateurRepository.findById(Id);

        if(!administrateurOptional.isPresent())
        {
            throw new IllegalStateException("cette administrateur n'existe pas");
        }
        administrateurRepository.deleteById(Id);
    }
}
