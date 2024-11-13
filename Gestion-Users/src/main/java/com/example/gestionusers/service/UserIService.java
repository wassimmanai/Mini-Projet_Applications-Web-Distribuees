package com.example.gestionusers.service;

import com.example.gestionusers.entity.User;

import java.util.List;

public interface UserIService {

    List<User> retrieveAllUsers();
    User retrieveUser(Long userId);
    User addUser(User user);
    void removeUser(Long userId);
    User modifyUser(User user);

}
