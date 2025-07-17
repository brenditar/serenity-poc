package com.example.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Ejemplo de test unitario usando el patrón Factory y Builder para User.
 */
public class UserFactoryTest {

    @Test
    public void testCreateDefaultUser() {
        User user = UserFactory.createDefaultUser();
        assertNotNull(user);
        assertEquals("Default User", user.getName());
        assertEquals("default@email.com", user.getEmail());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testCreateUserWithEmail() {
        String email = "test@email.com";
        User user = UserFactory.createUserWithEmail(email);
        assertNotNull(user);
        assertEquals(email, user.getEmail());
    }

    @Test
    public void testBuilderCreatesUserWithAllFields() {
        User user = new User.Builder()
                .id(123L)
                .name("Builder User")
                .email("builder@email.com")
                .password("builderpass")
                .build();
        assertEquals(Long.valueOf(123), user.getId());
        assertEquals("Builder User", user.getName());
        assertEquals("builder@email.com", user.getEmail());
        assertEquals("builderpass", user.getPassword());
    }
} 