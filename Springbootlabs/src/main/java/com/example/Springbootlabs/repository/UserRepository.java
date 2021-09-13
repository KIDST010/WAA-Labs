package com.example.Springbootlabs.repository;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u.posts from User u where u.id =:id")
    public List<Post> getPosts(@Param("id") Long id);

    @Query("select u from User u where u.username=:username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query("select u from User u where u.id=:id")
    public User getById(Long id);

    @Query("select u from User u where u.posts.size>0")
    public List<User> getMoreThanOnePost();

    @Query("select  u from User u where u.firstName=:firstName")
    public List<User> getAllUsersWithFirstName(@Param("firstName") String firstName);

    @Query("select  u from User u where u.firstName=:firstName and u.lastName=:lastName ")
    public List<User> findUserByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
