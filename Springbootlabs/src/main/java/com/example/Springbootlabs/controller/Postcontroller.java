package com.example.Springbootlabs.controller;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.service.Postservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    Postservice postService;

    @Autowired
    public void setPostService(Postservice postService) {
        this.postService = postService;
    }

    //Read All Posts
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping
    public List<Post> findAll() {
        List<Post> postList = new ArrayList<>();
        postService.getAll().forEach(p -> postList.add(p));
        return postList;
    }

    //Read Single Post
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/{id}")
    public Optional<Post> findPostById(@PathVariable("id") long id) {
        return postService.getById(id);
    }
    //Create Post
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PostMapping
    public void save(@RequestBody Post post) {
        postService.postItem(post);
    }

    //Update Post
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PutMapping("/{id}")
    public void updatePost(@RequestBody Post post, @PathVariable("id") long id) {
        post.setId(id);
        postService.postItem(post);
    }

    //Delete Post given an Id
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") long id) {
        postService.deleteItem(id);
    }
}
