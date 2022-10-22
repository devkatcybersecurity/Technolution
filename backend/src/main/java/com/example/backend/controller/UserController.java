package com.example.backend.controller;

import com.example.backend.models.User;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // all users
    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    // return single user
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        return this.userService.getUserByUsername(username);
    }

    // add a user
    @PostMapping
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
}
