package com.example.Springbootlabs.controller;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.service.Postservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/posts")
@RestController
public class Postcontroller {

        Postservice postService;

        @Autowired
        public void setPostService(Postservice postService){
            this.postService = postService;
        }

        //Read All Posts
        @GetMapping
        public List<Post> findAll(){
            List<Post> postList = new ArrayList<>();
            postService.getAll().forEach(e -> postList.add(e));
            return postList;
        }
        //Creat single Post
        @PostMapping("/single")
        public void save(@RequestBody Post post){
            postService.postItem(post);
        }

        //Creat multiple Post
        @PostMapping("/multiple")
        public void save(@RequestBody List<Post> postList){
            postList.stream().forEach(post -> postService.postItem(post));
        }

        //Update Post
        @PutMapping("/{id}/{title}/{author}")
        public void updatePost(@PathVariable("id") long id, @PathVariable("title") String title, @PathVariable("author") String author){
            Post post = postService.getById(id).get();
            post.setTitle(title);
            post.setAuthor(author);
            postService.postItem(post);
        }
        //Delete Post given an Id
        @DeleteMapping("/{id}")
        public void deletePost(@PathVariable long id){
            postService.deleteItem(id);
        }
    }