package com.example.inscriptionevent.controller;

import com.example.inscriptionevent.entity.Comment;
import com.example.inscriptionevent.entity.InsEvent;
import com.example.inscriptionevent.service.InsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins ="*" )
@RequestMapping("/inscriptions")
@AllArgsConstructor
public class InsController {

    private final InsService insService;

    // Endpoint to get all comments
    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return insService.getAllComments();
    }

    // Endpoint to get a specific comment by its ID
    @GetMapping("/comments/{id}")
    public Comment getCommentById(@PathVariable("id") Long id) {
        return insService.getCommentById(id);
    }

    // Endpoint to get all InsEvents
    @GetMapping
    public ResponseEntity<List<InsEvent>> getAllInsEvents() {
        List<InsEvent> insEvents = insService.retrieveAllInsEvents();
        return new ResponseEntity<>(insEvents, HttpStatus.OK);
    }

    // Endpoint to get a specific InsEvent by its ID
    @GetMapping("/{id}")
    public ResponseEntity<InsEvent> getInsEventById(@PathVariable("id") Long idIns) {
        InsEvent insEvent = insService.retrieveInsEvents(idIns);
        if (insEvent != null) {
            return new ResponseEntity<>(insEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to add a new InsEvent
    @PostMapping
    public ResponseEntity<InsEvent> addInsEvent(@RequestBody InsEvent insEvent) {
        InsEvent newInsEvent = insService.addInsEvents(insEvent);
        return new ResponseEntity<>(newInsEvent, HttpStatus.CREATED);
    }

    // Endpoint to update an existing InsEvent
    @PutMapping("/{id}")
    public ResponseEntity<InsEvent> updateInsEvent(@PathVariable("id") Long idIns, @RequestBody InsEvent updatedInsEvent) {
        // Check if the InsEvent exists
        if (insService.retrieveInsEvents(idIns) != null) {
            updatedInsEvent.setIdIns(idIns);  // Set the ID on the updated InsEvent
            InsEvent insEvent = insService.modifyInsEvents(updatedInsEvent);
            return new ResponseEntity<>(insEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete an InsEvent
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
