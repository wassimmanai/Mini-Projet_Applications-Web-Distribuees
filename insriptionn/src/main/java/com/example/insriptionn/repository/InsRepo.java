package com.example.insriptionn.repository;

import com.example.insriptionn.entity.InsEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsRepo extends JpaRepository<InsEvent, Long> {
}

