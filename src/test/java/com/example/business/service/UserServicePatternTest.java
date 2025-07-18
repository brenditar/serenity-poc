package com.example.business.service;

import com.example.model.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests unitarios para los patrones Singleton y Strategy en UserService.
 */
public class UserServicePatternTest {

    @Test
    public void testSingletonInstanceIsTheSame() {
        UserService instance1 = UserService.getInstance();
        UserService instance2 = UserService.getInstance();
        assertSame("Ambas instancias deben ser la misma (Singleton)", instance1, instance2);
    }

    @Test
    public void testSimpleEmailValidationStrategy() {
        UserService userService = UserService.getInstance();
        userService.setValidationStrategy(new SimpleEmailValidationStrategy());
        User validUser = new User.Builder().name("Test").email("test@email.com").password("pass").build();
        User invalidUser = new User.Builder().name("Test").email("").password("pass").build();
        assertNotNull(userService.registerUser(validUser.getName(), validUser.getEmail(), validUser.getPassword()));
        assertNull(userService.registerUser(invalidUser.getName(), invalidUser.getEmail(), invalidUser.getPassword()));
    }

    @Test
    public void testRegexEmailValidationStrategy() {
        UserService userService = UserService.getInstance();
        userService.setValidationStrategy(new RegexEmailValidationStrategy());
        User validUser = new User.Builder().name("Test").email("regex@email.com").password("pass").build();
        User invalidUser = new User.Builder().name("Test").email("invalid-email").password("pass").build();
        assertNotNull(userService.registerUser(validUser.getName(), validUser.getEmail(), validUser.getPassword()));
        assertNull(userService.registerUser(invalidUser.getName(), invalidUser.getEmail(), invalidUser.getPassword()));
    }
} 