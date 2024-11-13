package tn.espritclubs.microservice_forum.services;

import tn.espritclubs.microservice_forum.entities.Evenement;

import java.util.List;

public interface ICommentService {
    List<Evenement> retrieveAllEvenements();
    Evenement retrieveEvenement(Long evenementId);
    Evenement addEvenement(Evenement evenement);  // This method now matches
    void removeEvenement(Long evenementId);       // Corrected parameter name
    Evenement modifyEvenement(Evenement evenement);
}
