package com.example.Springbootlabs.repository;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
    @Query("select u.posts from User u where u.id =:id")
    public List<Post> getPosts(@Param("id") Long id);
    @Query("select u from User u where u.id=:id")
    public User getById(Long id);
    @Query("select u from User u where u.posts.size>1")
    public List<User> getMoreThanOnePost();
}
