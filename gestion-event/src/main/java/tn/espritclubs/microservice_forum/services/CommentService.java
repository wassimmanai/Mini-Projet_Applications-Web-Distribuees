package tn.espritclubs.microservice_forum.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.espritclubs.microservice_forum.entities.Evenement;
import tn.espritclubs.microservice_forum.repositores.EvenementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService implements ICommentService {
    private final EvenementRepository evenementRepository;

    @Override
    public List<Evenement> retrieveAllEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement retrieveEvenement(Long evenementId) {
        return evenementRepository.findById(evenementId).orElse(null);
    }

    @Override
    public Evenement addEvenement(Evenement evenement) {  // Corrected method name
        return evenementRepository.save(evenement);
    }

    @Override
    public void removeEvenement(Long evenementId) {  // Corrected parameter name
        evenementRepository.deleteById(evenementId);
    }

    @Override
    public Evenement modifyEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }
}
