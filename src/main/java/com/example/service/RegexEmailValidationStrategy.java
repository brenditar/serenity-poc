package com.example.service;

import com.example.model.User;
import java.util.regex.Pattern;

/**
 * Implementación del patrón Strategy para validar emails usando una expresión regular.
 */
public class RegexEmailValidationStrategy implements UserValidationStrategy {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    @Override
    public boolean isValid(User user) {
        String email = user.getEmail();
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
} 