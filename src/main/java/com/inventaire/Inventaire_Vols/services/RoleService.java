package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.Administrateur;
import com.inventaire.Inventaire_Vols.entities.Role;

import java.util.List;

public interface RoleService {
     Role saveRole(Role role);
     List<Role> findAllRoles();
     Role findRoleById(Long id);
     void deleteRole(Long id);
}
