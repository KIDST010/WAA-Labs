package com.example.Springbootlabs.repository;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.domain.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //1:- Get all Users
    @Query("Select u from User u")
    List<User> getAllUsers();

    //2:- Get a single User by ID
    @Query("select u from User u where u.id = :id")
    User getUserById(@Param("id") long id);

    @Query("Select u.postList from User u where u.id = :id")
    List<Post> getPosts(@Param("id") long id);

    @Query("Select u from User u where first_name=:first_name")
    List<User> getAllUsersWithFirstName(@Param("first_name") String firstName);

    @Query("SELECT u FROM User u WHERE u.firstName = ?1 and u.lastName = ?2")
    List<User> findUserByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT u FROM User u WHERE u.postList.size > 1")
    List<User> getUsersWhoHavePosts();
}
