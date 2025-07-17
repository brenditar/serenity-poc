package com.example.model;

/**
 * Patrón Factory: Centraliza la creación de usuarios de ejemplo para tests.
 */
public class UserFactory {

    /**
     * Crea un usuario por defecto para pruebas.
     */
    public static User createDefaultUser() {
        return new User.Builder()
                .id(1L)
                .name("Default User")
                .email("default@email.com")
                .password("password")
                .build();
    }

    /**
     * Crea un usuario con un email específico.
     */
    public static User createUserWithEmail(String email) {
        return new User.Builder()
                .id(2L)
                .name("Test User")
                .email(email)
                .password("password")
                .build();
    }

    /**
     * Crea un usuario admin de ejemplo.
     */
    public static User createAdminUser() {
        return new User.Builder()
                .id(99L)
                .name("Admin User")
                .email("admin@email.com")
                .password("adminpass")
                .build();
    }
} 