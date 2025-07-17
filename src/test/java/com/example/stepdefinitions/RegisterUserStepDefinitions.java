package com.example.stepdefinitions;

import com.example.model.User;
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

    private UserService userService = new UserService();
    private User lastRegisteredUser;
    private boolean registrationResult;

    /**
     * Removes all users from the in-memory list.
     */
    @Given("there are no users registered")
    public void there_are_no_users_registered() {
        userService = new UserService(); // reinicia la lista en memoria
    }

    /**
     * Registers a user with the given email if not already present.
     * @param email Email to register
     */
    @Given("a user with email {string} is already registered")
    public void a_user_with_email_is_already_registered(String email) {
        userService = new UserService();
        userService.registerUser("ExistingUser", email, "password");
    }

    /**
     * Attempts to register a user with the given name and email.
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
            lastRegisteredUser = userService.registerUser(name, email, "password");
            registrationResult = true;
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
