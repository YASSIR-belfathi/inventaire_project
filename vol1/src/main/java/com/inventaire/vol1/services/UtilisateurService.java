﻿package com.inventaire.vol1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventaire.vol1.Repository.UtilisateurRepository;
import com.inventaire.vol1.entity.Utilisateur;

@Service
public class UtilisateurService {
    
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository=utilisateurRepository;
    }

    public List<Utilisateur> getListUtilisateur()
    {
        return utilisateurRepository.findAll();
    }

    public void addNewUtilisateur(Utilisateur utilisateur)
    {
        Optional<Utilisateur> utilisateurOption=utilisateurRepository.findUtilisateurByNom(utilisateur.getNom_complet());

        if(utilisateurOption.isPresent())
        {
            throw new IllegalStateException("this user exists");
        }
        else{
            System.out.println(utilisateur);
        }

        utilisateurRepository.save(utilisateur);
    }
}
