package com.example.Springbootlabs.repository;

import com.example.Springbootlabs.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface Postrepository extends CrudRepository<Post, Long> {



}
