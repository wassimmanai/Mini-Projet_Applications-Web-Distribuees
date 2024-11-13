package tn.espritclubs.microservice_forum.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.espritclubs.microservice_forum.entities.Comment;
import tn.espritclubs.microservice_forum.services.ICommentService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    ICommentService commentService;

    // Récupérer tous les commentaires
    @GetMapping("/retrieve-all-comments")
    public List<Comment> getComments() {
        return commentService.retrieveAllComments();
    }

    // Récupérer un commentaire spécifique par son ID
    @GetMapping("/retrieve-comment/{comment-id}")
    public Comment retrieveComment(@PathVariable("comment-id") Long commentId) {
        return commentService.retrieveComment(commentId);
    }

    // Ajouter un nouveau commentaire
    @PostMapping("/add-comment")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    // Supprimer un commentaire par son ID
    @DeleteMapping("/remove-comment/{comment-id}")
    public void removeComment(@PathVariable("comment-id") Long commentId) {
        commentService.removeComment(commentId);
    }

    // Modifier un commentaire
    @PutMapping("/modify-comment")
    public Comment modifyComment(@RequestBody Comment comment) {
        return commentService.modifyComment(comment);
    }
}
