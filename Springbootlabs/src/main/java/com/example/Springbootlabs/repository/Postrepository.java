package com.example.Springbootlabs.repository;

import com.example.Springbootlabs.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface Postrepository extends CrudRepository<Post, Long> {



}
