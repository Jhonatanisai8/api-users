package org.isai.api.api_users.services;

import java.util.List;
import java.util.Optional;

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

    public UserModel saveUser(UserModel user) {
        return repository.save(user);
    }

    public Optional<UserModel> getUserByID(Long id) {
        return repository.findById(id);
    }

    public UserModel updateUserByID(UserModel request, Long id) {
        UserModel user = repository.findById(id).get();
        user.setFirtName(request.getFirtName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        return user;
    }
}
