package com.example.gestionusers.controller;

import com.example.gestionusers.entity.User;
import com.example.gestionusers.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    // 1. Retrieve all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.retrieveAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // 2. Retrieve a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.retrieveUser(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 3. Add a new user
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // 4. Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        if (userService.retrieveUser(id) != null) {
            updatedUser.setId(id);  // Set the ID on the updated user
            User user = userService.modifyUser(updatedUser);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 5. Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        if (userService.retrieveUser(id) != null) {
            userService.removeUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
