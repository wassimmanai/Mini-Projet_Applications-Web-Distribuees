package tn.espritclubs.microservice_forum.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.espritclubs.microservice_forum.entities.Evenement;
import tn.espritclubs.microservice_forum.services.ICommentService; // This can be renamed if needed to better match EvenementService

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/evenement")  // Changed path to reflect the Evenement resource
public class EvenementController {
    ICommentService commentService;  // You can change this to a specific EvenementService if you create one

    // Récupérer tous les événements
    @GetMapping("/retrieve-all-evenements")
    public List<Evenement> getEvenements() {
        return commentService.retrieveAllEvenements();
    }

    // Récupérer un événement spécifique par son ID
    @GetMapping("/retrieve-evenement/{evenement-id}")
    public Evenement retrieveEvenement(@PathVariable("evenement-id") Long evenementId) {
        return commentService.retrieveEvenement(evenementId);
    }

    // Ajouter un nouvel événement
    @PostMapping("/add-evenement")
    public Evenement addEvenement(@RequestBody Evenement evenement) {
        return commentService.addEvenement(evenement);  // This will use the addEvenement method from the service
    }

    // Supprimer un événement par son ID
    @DeleteMapping("/remove-evenement/{evenement-id}")
    public void removeEvenement(@PathVariable("evenement-id") Long evenementId) {
        commentService.removeEvenement(evenementId);  // This will use the removeEvenement method from the service
    }

    // Modifier un événement
    @PutMapping("/modify-evenement")
    public Evenement modifyEvenement(@RequestBody Evenement evenement) {
        return commentService.modifyEvenement(evenement);  // This will use the modifyEvenement method from the service
    }
}
