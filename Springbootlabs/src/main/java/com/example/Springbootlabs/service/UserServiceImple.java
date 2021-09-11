package com.example.Springbootlabs.service;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.domain.User;
import com.example.Springbootlabs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImple implements UserService {

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<Post> getPosts(long id) {
        return userRepository.getPosts(id);
    }

    @Override
    public List<User> getUsersWhoHavePosts() {
        return userRepository.getUsersWhoHavePosts();
    }

    @Override
    public List<User> getAllUsersWithFirstName(String firstName) {
        return userRepository.getAllUsersWithFirstName(firstName);
    }

    @Override
    public List<User> findUserByFullName(String firstName, String secondName) {
        return userRepository.findUserByFullName(firstName, secondName);
    }
}


