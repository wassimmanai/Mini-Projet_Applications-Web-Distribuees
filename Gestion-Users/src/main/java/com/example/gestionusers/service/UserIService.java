package com.example.gestionusers.service;

import com.example.gestionusers.entity.User;

import java.util.List;

public interface UserIService {

    List<User> retrieveAllUsers();
    User retrieveUser(Long id);
    User addUser(User user);
    void removeUser(Long id);
    User modifyUser(User user);
}
