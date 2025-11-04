package com.example.demo.service;

import com.example.demo.repository.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public String addUser(User user) {
        return repo.save(user) > 0 ? "User added successfully!" : "Failed to add user";
    }

    public List<User> getUsers() {
        return repo.findAll();
    }

    public String updateUser(User user) {
        return repo.update(user) > 0 ? "User updated successfully!" : "Failed to update user";
    }

    public String deleteUser(Long id) {
        return repo.delete(id) > 0 ? "User deleted successfully!" : "Failed to delete user";
    }
}
