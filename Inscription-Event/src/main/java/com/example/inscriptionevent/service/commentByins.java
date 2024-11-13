package com.example.inscriptionevent.service;

import com.example.inscriptionevent.entity.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(name = "Comment", url = "http://localhost:8094")
public interface commentByins {





        @RequestMapping("/reclamations")
        List<Comment> getAllComments();

        @RequestMapping("/reclamations/{id}")
        Comment getCommentById(@PathVariable("id") Long id);


}
