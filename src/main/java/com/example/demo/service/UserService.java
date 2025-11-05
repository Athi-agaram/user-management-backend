package com.example.demo.service;

import com.example.demo.repository.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Service
public class UserService {

    // 🔹 Create a Logger for this class
    private static final Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository repo;

    // 🔹 Create user
    public String addUser(User user) {
        logger.info("Attempting to add new user: {}", user.getName());
        try {
            int result = repo.save(user);
            if (result > 0) {
                logger.debug("User '{}' added successfully in the database.", user.getName());
                return "User added successfully!";
            } else {
                logger.warn("User '{}' insert returned 0 rows. Possible issue with query or input.", user.getName());
                return "Failed to add user.";
            }
        } catch (Exception e) {
            logger.error("Error occurred while adding user '{}': {}", user.getName(), e.getMessage(), e);
            return "Error occurred while adding user.";
        }
    }

    // 🔹 Read users
    public List<User> getUsers() {
        logger.info("Fetching all users from database...");
        List<User> users = repo.findAll();
        logger.debug("Fetched {} users from database.", users.size());
        return users;
    }

    // 🔹 Update user
    public String updateUser(User user) {
        logger.info("Attempting to update user with ID: {}", user.getId());
        try {
            int result = repo.update(user);
            if (result > 0) {
                logger.debug("User with ID {} updated successfully.", user.getId());
                return "User updated successfully!";
            } else {
                logger.warn("No rows affected during update for user ID {}.", user.getId());
                return "Failed to update user.";
            }
        } catch (Exception e) {
            logger.error("Error while updating user ID {}: {}", user.getId(), e.getMessage(), e);
            return "Error occurred while updating user.";
        }
    }

    // 🔹 Delete user
    public String deleteUser(Long id) {
        logger.info("Attempting to delete user with ID: {}", id);
        try {
            int result = repo.delete(id);
            if (result > 0) {
                logger.debug("User with ID {} deleted successfully.", id);
                return "User deleted successfully!";
            } else {
                logger.warn("No user found to delete with ID {}.", id);
                return "Failed to delete user.";
            }
        } catch (Exception e) {
            logger.error("Error while deleting user ID {}: {}", id, e.getMessage(), e);
            return "Error occurred while deleting user.";
        }
    }
}
