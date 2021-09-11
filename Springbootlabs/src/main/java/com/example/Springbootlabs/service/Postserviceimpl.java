package com.example.Springbootlabs.service;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.repository.Postrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Postserviceimpl implements Postservice {
    @Autowired
    Postrepository postrepository;

    @Override
    public List<Post> getAll() {
        return (List<Post>) postrepository.findAll();
    }

    @Override
    public Optional<Post> getById(long id) {
        return postrepository.findById(id);
    }

    @Override
    public Post postItem(Post p) {
        return postrepository.save(p);


    }

    @Override
    public void deleteItem(long id) {
        postrepository.deleteById(id);
    }

    @Override
    public Post updateItem(Post post, long id) {
        Post p = postrepository.findById(id).orElse(null);
        if (p != null) {

            p.setTitle(post.getTitle());
            p.setAuthor(post.getAuthor());
            p.setContent(post.getContent());

        }
        postItem(p);

        return p;
    }
}
