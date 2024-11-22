package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Vol;

import java.util.Date;
import java.util.List;

public class VolServiceImpl implements VolService {
    @Override
    public Vol saveVol(Vol vol) {
        return null;
    }

    @Override
    public List<Vol> findAllVols() {
        return List.of();
    }

    @Override
    public Vol findVolById(Long id) {
        return null;
    }

    @Override
    public void deleteVol(Long id) {

    }

    @Override
    public List<Vol> findVolsByAeroportDepartAndArrive(String depart, String arrive) {
        return List.of();
    }

    @Override
    public List<Vol> findVolsByDate(Date date) {
        return List.of();
    }
}
