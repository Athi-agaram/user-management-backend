package com.example.demo.controller;

import com.example.demo.repository.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
public class UserController {

    // 🔹 Create a logger specific to this class
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService service;

    // 🔹 Add User
    @PostMapping
    public String addUser(@RequestBody User user) {
        logger.info("Received POST request to add new user: {}", user.getName());
        String response = service.addUser(user);
        logger.debug("Response for addUser: {}", response);
        return response;
    }

    // 🔹 Get All Users
    @GetMapping
    public List<User> getAll() {
        logger.info("Received GET request to fetch all users");
        List<User> users = service.getUsers();
        logger.debug("Fetched {} users from database", users.size());
        return users;
    }

    // 🔹 Update User
    @PutMapping
    public String updateUser(@RequestBody User user) {
        logger.info("Received PUT request to update user ID: {}", user.getId());
        String response = service.updateUser(user);
        logger.debug("Response for updateUser: {}", response);
        return response;
    }

    // 🔹 Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        logger.info("Received DELETE request for user ID: {}", id);
        String response = service.deleteUser(id);
        logger.debug("Response for deleteUser: {}", response);
        return response;
    }
}
