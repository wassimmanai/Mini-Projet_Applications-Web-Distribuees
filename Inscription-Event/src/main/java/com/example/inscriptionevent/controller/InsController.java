package com.example.inscriptionevent.controller;

import com.example.inscriptionevent.entity.InsEvent;
import com.example.inscriptionevent.service.InsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
@AllArgsConstructor
public class InsController {

    private final InsService insService;

    // 1. Récupérer toutes les inscriptions
    @GetMapping
    public ResponseEntity<List<InsEvent>> getAllInsEvents() {
        List<InsEvent> insEvents = insService.retrieveAllInsEvents();
        return new ResponseEntity<>(insEvents, HttpStatus.OK);
    }

    // 2. Récupérer une inscription par ID
    @GetMapping("/{id}")
    public ResponseEntity<InsEvent> getInsEventById(@PathVariable("id") Long idIns) {
        InsEvent insEvent = insService.retrieveInsEvents(idIns);
        if (insEvent != null) {
            return new ResponseEntity<>(insEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 3. Ajouter une nouvelle inscription
    @PostMapping
    public ResponseEntity<InsEvent> addInsEvent(@RequestBody InsEvent insEvent) {
        InsEvent newInsEvent = insService.addInsEvents(insEvent);
        return new ResponseEntity<>(newInsEvent, HttpStatus.CREATED);
    }

    // 4. Modifier une inscription existante
    @PutMapping("/{id}")
    public ResponseEntity<InsEvent> updateInsEvent(@PathVariable("id") Long idIns, @RequestBody InsEvent updatedInsEvent) {
        // Vérifier si l'inscription existe
        if (insService.retrieveInsEvents(idIns) != null) {
            updatedInsEvent.setIdIns(idIns);  // Définit l'ID sur l'inscription mise à jour
            InsEvent insEvent = insService.modifyInsEvents(updatedInsEvent);
            return new ResponseEntity<>(insEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 5. Supprimer une inscription
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsEvent(@PathVariable("id") Long idIns) {
        if (insService.retrieveInsEvents(idIns) != null) {
            insService.removeInsEvents(idIns);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
