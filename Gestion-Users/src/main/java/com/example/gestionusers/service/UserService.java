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

    private final UserRepository userRepository;  // Inject the UserRepository

    @Override
    public List<User> retrieveAllUsers() {
        List<User> users = userRepository.findAll();
        log.info("Total number of users: " + users.size());
        for (User user : users) {
            log.info("User: " + user);
        }
        return users;
    }

    @Override
    public User retrieveUser(Long id) {
        return userRepository.findById(id).orElse(null);  // Directly use the ID to find the user
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);  // Directly delete by ID
    }

    @Override
    public User modifyUser(User user) {
        return userRepository.save(user);  // Save updates to the user entity
    }
}
