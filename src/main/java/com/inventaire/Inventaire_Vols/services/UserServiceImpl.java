package com.inventaire.Inventaire_Vols.services;

import com.inventaire.Inventaire_Vols.entities.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public void assignRoleToUser(Long userId, Long roleId) {

    }
}
