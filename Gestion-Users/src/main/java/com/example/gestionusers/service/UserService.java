package com.example.gestionusers.service;

import com.example.gestionusers.entity.User;
import com.example.gestionusers.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserIService {

    private final UserRepository userRepo;  // Injecting the User repository

    @Override
    public List<User> retrieveAllUsers() {
        List<User> users = userRepo.findAll();
        log.info("Total number of users: " + users.size());
        users.forEach(user -> log.info("User: " + user));
        return users;
    }

    @Override
    public User retrieveUser(Long userId) {
        return userRepo.findById(userId).orElse(null);  // Retrieve user by ID
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);  // Add new user
    }

    @Override
    public void removeUser(Long userId) {
        userRepo.deleteById(userId);  // Delete user by ID
    }

    @Override
    public User modifyUser(User user) {
        return userRepo.save(user);  // Update existing user
    }
}
