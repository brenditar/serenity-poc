package com.example.service;

import com.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service to manage users in memory.
 *
 * Patrón Singleton: Garantiza que solo exista una instancia de UserService en la aplicación.
 * Patrón Strategy: Permite cambiar la estrategia de validación de usuario en tiempo de ejecución.
 */
public class UserService {
    private static UserService instance;
    private final List<User> users = new ArrayList<>();
    private Long idCounter = 1L;
    private UserValidationStrategy validationStrategy = new SimpleEmailValidationStrategy();

    // --- Patrón Singleton ---
    private UserService() {}

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    // --- Fin Singleton ---

    // --- Patrón Strategy ---
    public void setValidationStrategy(UserValidationStrategy strategy) {
        this.validationStrategy = strategy;
    }
    // --- Fin Strategy ---

    /**
     * Registers a new user with the given data, applying the validation strategy.
     * @param name User name
     * @param email User email
     * @param password User password
     * @return The registered user, or null if validation fails
     */
    public User registerUser(String name, String email, String password) {
        User user = new User(idCounter++, name, email, password);
        if (validationStrategy != null && !validationStrategy.isValid(user)) {
            return null;
        }
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