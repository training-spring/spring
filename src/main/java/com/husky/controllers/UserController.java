package com.husky.controllers;

import com.husky.entities.User;
import com.husky.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Inject
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

}