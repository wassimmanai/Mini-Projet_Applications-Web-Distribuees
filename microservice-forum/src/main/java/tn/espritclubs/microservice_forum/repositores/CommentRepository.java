package tn.espritclubs.microservice_forum.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.espritclubs.microservice_forum.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Il n'est plus nécessaire d'inclure des méthodes liées à Post
}
