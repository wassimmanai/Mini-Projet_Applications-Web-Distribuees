package com.example.inscription_event.service;

import com.example.inscription_event.entity.InsEvent;
import com.example.inscription_event.repository.InsRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InsService implements InsIService {

    private final InsRepo insRepo;  // Injection du repository

    @Override
    public List<InsEvent> retrieveAllInsEvents() {
        List<InsEvent> listI = insRepo.findAll();
        log.info("Taille totale : " + listI.size());
        for (InsEvent i : listI) {
            log.info("Inscription : " + i);
        }
        return listI;
    }

    @Override
    public InsEvent retrieveInsEvents(Long idIns) {
        return insRepo.findById(idIns).orElse(null);  // Utilisation directe de idIns
    }

    @Override
    public InsEvent addInsEvents(InsEvent i) {
        return insRepo.save(i);
    }

    @Override
    public void removeInsEvents(Long idIns) {
        insRepo.deleteById(idIns);  // Utilisation directe de idIns
    }

    @Override
    public InsEvent modifyInsEvents(InsEvent insEvent) {
        return insRepo.save(insEvent);
    }
}