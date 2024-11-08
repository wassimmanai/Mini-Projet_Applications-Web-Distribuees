package com.example.inscriptionevent.repository;

import com.example.inscriptionevent.entity.InsEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsRepo extends JpaRepository<InsEvent, Long> {
}
