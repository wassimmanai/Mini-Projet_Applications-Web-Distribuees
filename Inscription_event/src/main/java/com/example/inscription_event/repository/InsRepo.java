package com.example.inscription_event.repository;

import com.example.inscription_event.entity.InsEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsRepo extends JpaRepository<InsEvent, Long> {
}
