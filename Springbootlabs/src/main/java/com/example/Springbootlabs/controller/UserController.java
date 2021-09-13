package com.example.Springbootlabs.controller;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.domain.User;
import com.example.Springbootlabs.service.Postservice;
import com.example.Springbootlabs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    Postservice postservice;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {

        user.setPosts(postservice.getAll());
        userService.postItem( user );

    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPostById(@PathVariable Long id) {

        return userService.getPosts(id);
    }
    @GetMapping("/userpost")
    public List<User> getMoreThanOnePost() {
        return userService.getMoreThanOnePost();
    }

}
