package com.example.api.stepdefinitions;

import com.example.api.questions.ResponseCodeQuestion;
import com.example.api.tasks.RegisterUserApiTask;
import com.example.model.User;
import com.example.model.UserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterUserApiStepDefinitions {
    private static final String API_URL = "https://reqres.in/api";
    private Actor actor;

    @Given("the API is available")
    public void the_api_is_available() {
        actor = Actor.named("API Tester").whoCan(CallAnApi.at(API_URL));
    }

    @When("I register a user with email {string} and password {string}")
    public void i_register_a_user_with_email_and_password(String email, String password) {
        // Usar el builder para crear el usuario
        User user = new User.Builder()
                .email(email)
                .password(password)
                .build();
        actor.attemptsTo(RegisterUserApiTask.with(user.getEmail(), user.getPassword()));
    }

    @When("I register a user with email {string} and no password")
    public void i_register_a_user_with_email_and_no_password(String email) {
        // Usar el factory para crear el usuario base y omitir el password
        User user = UserFactory.createUserWithEmail(email);
        actor.attemptsTo(RegisterUserApiTask.withNoPassword(user.getEmail()));
    }

    @Then("the response code should be {int}")
    public void the_response_code_should_be(Integer code) {
        actor.should(seeThat("response code", ResponseCodeQuestion.value(), equalTo(code)));
    }
} 