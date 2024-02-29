package com.example.database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.database.model.PassDet;
import com.example.database.model.User;
import com.example.database.repository.UserRepository;

@Service
public class UserService{
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User getUser(Long id){
        return userRepository.findById(id).get();
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<PassDet> getPassengerByUserName(String username){
        User user = userRepository.findByUsername(username);
        return user.getPassDet();
    }

}