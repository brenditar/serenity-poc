package com.example.service;

import com.example.model.User;

/**
 * Patrón Strategy: Permite definir diferentes estrategias de validación de usuario (por ejemplo, email).
 */
public interface UserValidationStrategy {
    boolean isValid(User user);
} 