package com.example.Springbootlabs.controller;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.domain.User;
import com.example.Springbootlabs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //Q-1: retrieve all the users
    @GetMapping
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    //Q-2: retrieve the user with id = ?
    @GetMapping("/{id}")
    public User find(@PathVariable("id") long id) {
        return userService.getById(id);
    }

    //Q-3: create and save a new user
    @PostMapping
    public void save(@RequestBody User user) {
        userService.postItem(user);
    }

    //Q-4: retrieve the posts of the user where id = 1.
    @GetMapping("/{id}/posts")
    public List<Post> getPosts(@PathVariable("id") long id) {
        return userService.getPosts(id);
    }

    //Q-5: Make a query that will return all the users that have more than 1 post
    @GetMapping("/posts")
    public List<User> getUsersWhoHavePosts() {
        return userService.getMoreThanOnePost();
    }

    /*===========   I added the following for my personal exercise on JPQL and Native queries   ===========*/

    //1: retrieve all users with this 'firstName'
    @GetMapping("/name/{firstName}")
    public List<User> getAllUsersWithFirstName(@PathVariable("firstName") String firstName) {
        return userService.getAllUsersWithFirstName(firstName);
    }

    //2: retrieve all users with this 'firstName' and 'lastName'
    @GetMapping("/{firstName}/{lastName}")
    public List<User> getAllUsersWithFirstName(@PathVariable("firstName") String firstName,
                                               @PathVariable("lastName") String lastName) {
        return userService.findUserByFullName(firstName, lastName);
    }
}
