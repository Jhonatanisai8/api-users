package org.isai.api.api_users.controllers;

import java.util.List;
import java.util.Optional;

import org.isai.api.api_users.models.UserModel;
import org.isai.api.api_users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserModel> getUsers() {
        return this.service.getUsers();
    }

    @PostMapping
    public UserModel savUser(@RequestBody UserModel user) {
        return this.service.saveUser(user);
    }

    @GetMapping("/{id}")
    public Optional<UserModel> getUserByID(@PathVariable Long id) {
        return this.service.getUserByID(id);
    }

    @PutMapping("/{id}")
    public UserModel updatUserByID(@RequestBody UserModel userRequest, @PathVariable Long id) {
        return this.service.updateUserByID(userRequest, id);
    }

    @DeleteMapping("/{id}")
    public String deleteUserByID(@PathVariable Long id){
        boolean delete = this.service.deleteUserByID(id);
        if (delete) {
            return "User Delete ID: "+id;
        } else {
            return "User not content ID: "+id;
        }
    }
}
