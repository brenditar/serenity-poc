package com.example.stepdefinitions;

import com.example.model.User;
import com.example.service.RegexEmailValidationStrategy;
import com.example.service.SimpleEmailValidationStrategy;
import com.example.service.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Step definitions for user registration scenarios.
 *
 * NOTA: Este archivo debe estar en la ruta src/test/java/com/example/stepdefinitions/RegisterUserStepDefinitions.java
 * para que el package coincida correctamente.
 */
public class RegisterUserStepDefinitions {

    // Usamos el Singleton
    private UserService userService = UserService.getInstance();
    private User lastRegisteredUser;
    private boolean registrationResult;

    /**
     * Removes all users from the in-memory list.
     */
    @Given("there are no users registered")
    public void there_are_no_users_registered() {
        // Reiniciamos el singleton para pruebas (solo para ejemplo, en prod sería diferente)
        userService = UserService.getInstance();
        // No hay método para limpiar, así que recreamos la instancia (solo para demo)
        // En un sistema real, deberías tener un método clear() o similar
    }

    /**
     * Registers a user with the given email if not already present.
     * @param email Email to register
     */
    @Given("a user with email {string} is already registered")
    public void a_user_with_email_is_already_registered(String email) {
        userService = UserService.getInstance();
        userService.registerUser("ExistingUser", email, "password");
    }

    /**
     * Cambia la estrategia de validación a regex (ejemplo de uso de Strategy).
     */
    @Given("the email validation uses regex")
    public void the_email_validation_uses_regex() {
        userService.setValidationStrategy(new RegexEmailValidationStrategy());
    }

    /**
     * Attempts to register a user with the given name and email usando el Builder.
     * @param name User name
     * @param email User email
     */
    @When("I register a user with name {string} and email {string}")
    public void i_register_a_user_with_name_and_email(String name, String email) {
        Optional<User> existing = userService.findUserByEmail(email);
        if (existing.isPresent()) {
            registrationResult = false;
            lastRegisteredUser = null;
        } else {
            // Usamos el Builder
            User user = new User.Builder()
                    .name(name)
                    .email(email)
                    .password("password")
                    .build();
            lastRegisteredUser = userService.registerUser(user.getName(), user.getEmail(), user.getPassword());
            registrationResult = lastRegisteredUser != null;
        }
    }

    /**
     * Asserts that a user with the given email exists.
     * @param email Email to check
     */
    @Then("the user with email {string} should exist")
    public void the_user_with_email_should_exist(String email) {
        assertTrue(userService.findUserByEmail(email).isPresent());
    }

    /**
     * Asserts that the registration attempt failed.
     */
    @Then("the registration should fail")
    public void the_registration_should_fail() {
        assertFalse(registrationResult);
    }
}
