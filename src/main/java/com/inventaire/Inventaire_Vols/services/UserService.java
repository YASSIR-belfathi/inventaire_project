package com.inventaire.Inventaire_Vols.services;


import com.inventaire.Inventaire_Vols.entities.User;

import java.util.List;

public interface UserService {
     User saveUser(User user);
     List<User> findAllUsers();
     User findUserById(Long id);
     void deleteUser(Long id);
     User findByEmail(String email);
     void assignRoleToUser(Long userId, Long roleId);
}
