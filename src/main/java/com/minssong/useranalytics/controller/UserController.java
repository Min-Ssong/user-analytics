package com.minssong.useranalytics.controller;

import com.minssong.useranalytics.domain.User;
import com.minssong.useranalytics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return userRepository.findByUserId(userId).orElse(null);
    }
}
