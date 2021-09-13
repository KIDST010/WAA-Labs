package com.example.Springbootlabs.service;

import com.example.Springbootlabs.domain.Post;
import com.example.Springbootlabs.domain.User;
import com.example.Springbootlabs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class UserServiceimpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    Postservice postservice;
    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public void postItem(User p) {

        userRepository.save(p);
    }

    @Override
    public void deleteItem(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<Post> getPosts(Long id) {
       return userRepository.getPosts(id);
    }

    @Override
    public List<User> getMoreThanOnePost() {
        return userRepository.getMoreThanOnePost();
    }


}
