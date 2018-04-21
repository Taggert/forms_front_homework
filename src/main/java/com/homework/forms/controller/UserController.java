package com.homework.forms.controller;

import com.homework.forms.model.User;
import com.homework.forms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/save")
    public User save(@RequestParam("username") String username, @RequestParam("password") String password ){
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        userRepository.save(user);
        return user;
    }

    @GetMapping("/all")
    public List<User> all(){
        return userRepository.findAll();
    }

}