package com.example.myapp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.myapp.User.UserServices;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}