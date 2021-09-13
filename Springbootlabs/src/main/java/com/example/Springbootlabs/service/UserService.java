package com.example.Springbootlabs.service;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAll();
    public User getById(long id);
    public void postItem(User p);
    public void deleteItem(long id);
    public List<Post> getPosts(Long id);
    public List<User> getMoreThanOnePost();
}
