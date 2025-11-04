package com.example.demo.controller;


import com.example.demo.repository.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000") 
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public String addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getUsers();
    }

    @PutMapping
    public String updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return service.deleteUser(id);
    }
}
