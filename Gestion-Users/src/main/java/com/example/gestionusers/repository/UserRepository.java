package com.example.gestionusers.repository;

import com.example.gestionusers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
