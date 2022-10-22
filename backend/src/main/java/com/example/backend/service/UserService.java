package com.example.backend.service;

import com.example.backend.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList=  new ArrayList<>();

    public UserService() {
        userList.add(new User("user1", "password1", "user1@gmail.com"));
        userList.add(new User("user2", "password2", "user2@gmail.com"));
    }
        // get all users
        public List<User> getAllUsers(){
            return this.userList;
        }

        // get user by username
        public User getUserByUsername(String username){
            return this.userList.stream().filter(user -> user.getUsername().equals(username)).findFirst().get();
        }

        // add a user
        public User addUser(User user){
            this.userList.add(user);
            return user;
        }
    }

