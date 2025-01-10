package org.isai.api.api_users.controllers;

import java.util.List;

import org.isai.api.api_users.models.UserModel;
import org.isai.api.api_users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
