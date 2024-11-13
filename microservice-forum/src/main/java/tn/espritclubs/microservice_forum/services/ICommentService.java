package tn.espritclubs.microservice_forum.services;

import tn.espritclubs.microservice_forum.entities.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> retrieveAllComments();
    Comment retrieveComment(Long commentId);
    Comment addComment(Comment comment);  // No postId or userId
    void removeComment(Long commentId);
    Comment modifyComment(Comment comment);
}
