package tn.espritclubs.microservice_forum.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.espritclubs.microservice_forum.entities.Comment;
import tn.espritclubs.microservice_forum.repositores.CommentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService implements ICommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> retrieveAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment retrieveComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public Comment addComment(Comment comment) {
        // Just save the comment without needing postId or userId
        return commentRepository.save(comment);
    }

    @Override
    public void removeComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public Comment modifyComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
