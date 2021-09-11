package com.example.Springbootlabs.service;

import com.example.Springbootlabs.domain.Post;

import java.util.List;
import java.util.Optional;

public interface Postservice {
    public List<Post> getAll();
    public Optional<Post> getById(long id);
    public Post postItem(Post p);
    public void deleteItem(long id);
    public Post updateItem(Post post, long id);
}
