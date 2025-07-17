package com.example.service;

/**
 * Patrón Strategy: Permite definir diferentes estrategias de validación de usuario (por ejemplo, email).
 */
public interface UserValidationStrategy {
    boolean isValid(User user);
} 