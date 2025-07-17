package com.example.service;

import com.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service to manage users in memory.
 */
public class UserService {
    private final List<User> users = new ArrayList<>();
    private Long idCounter = 1L;

    /**
     * Registers a new user with the given data.
     * @param name User name
     * @param email User email
     * @param password User password
     * @return The registered user
     */
    public User registerUser(String name, String email, String password) {
        User user = new User(idCounter++, name, email, password);
        users.add(user);
        return user;
    }

    /**
     * Finds a user by email.
     * @param email Email to search
     * @return Optional with the user if found
     */
    public Optional<User> findUserByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    /**
     * Returns all registered users.
     * @return List of users
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
} 