package org.isai.api.api_users.services;

import java.util.List;

import org.isai.api.api_users.models.UserModel;
import org.isai.api.api_users.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserRepository repository;

    public List<UserModel> getUsers() {
        return repository.findAll();
    }

}
