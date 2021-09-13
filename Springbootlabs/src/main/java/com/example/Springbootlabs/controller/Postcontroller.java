package com.example.Springbootlabs.controller;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.service.Postservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/posts")
@RestController
public class Postcontroller {
    @Autowired
    Postservice postservice;

    @GetMapping
    public List<Post> getAll() {
        return postservice.getAll();
    }


    @GetMapping("/{id}")
    public Optional<Post> getById(@PathVariable("id") int id) {
        return postservice.getById(id);
    }

    @PostMapping
    public Post postItem(@RequestBody Post p) {
        return postservice.postItem(p);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") long id) {
        postservice.deleteItem(id);
    }

    @PutMapping("/{id}")
    public Post updateItem(@RequestBody Post post, @PathVariable("id") long id) {

        return postservice.updateItem(post, id);
    }

   /* @GetMapping("/hat/{id}")
    public EntityModel<Post> getIdH(@PathVariable("id") long id) {
        Post post = postservice.getById(id).orElse(null);
        EntityModel<Post> resource = EntityModel.of(post);

        WebMvcLinkBuilder linkto = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(Postcontroller.class).deleteItem(id));

        WebMvcLinkBuilder linkto2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(Postcontroller.class).postItem(post));
        resource.add(linkto.withRel("delete link:"));
        resource.add(linkto2.withRel("post link:"));
        return resource;
    }*/

}
