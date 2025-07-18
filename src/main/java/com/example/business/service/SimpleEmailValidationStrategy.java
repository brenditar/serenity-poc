package com.example.business.service;

import com.example.model.User;

/**
 * Implementación simple del patrón Strategy para validar emails (no vacío y contiene '@').
 */
public class SimpleEmailValidationStrategy implements UserValidationStrategy {
    @Override
    public boolean isValid(User user) {
        String email = user.getEmail();
        return email != null && email.contains("@") && !email.trim().isEmpty();
    }
} 