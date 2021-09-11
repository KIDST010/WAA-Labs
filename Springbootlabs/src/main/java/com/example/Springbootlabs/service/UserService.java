package com.example.Springbootlabs.service;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    List<Post> getPosts(long id);
    List<User> getUsersWhoHavePosts();
    List<User> getAllUsersWithFirstName(String firstName);
    List<User> findUserByFullName(String firstName, String lastName);
}
