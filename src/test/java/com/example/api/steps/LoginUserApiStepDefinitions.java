package com.example.api.steps;

import com.example.api.questions.ErrorMessageQuestion;
import com.example.api.questions.ResponseCodeQuestion;
import com.example.api.tasks.LoginUserApiTask;
import com.example.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginUserApiStepDefinitions {
    private static final String API_URL = "https://reqres.in/api";
    private Actor actor;

    @Given("the API for login is available")
    public void the_api_for_login_is_available() {
        actor = Actor.named("API Tester").whoCan(CallAnApi.at(API_URL));
    }

    @When("I login with email {string} and password {string} via API")
    public void i_login_with_email_and_password_via_api(String email, String password) {
        // Convertir password vacío a null
        String pwd = (password == null || password.isEmpty()) ? null : password;
        User user = new User.Builder()
                .email(email)
                .password(pwd)
                .build();
        actor.attemptsTo(LoginUserApiTask.with(user.getEmail(), user.getPassword()));
    }

    @Then("the login response code should be {int}")
    public void the_login_response_code_should_be(Integer code) {
        actor.should(seeThat("login response code", ResponseCodeQuestion.value(), equalTo(code)));
    }

    @Then("the login error message should be {string}")
    public void the_login_error_message_should_be(String expectedMessage) {
        if (expectedMessage != null && !expectedMessage.isEmpty()) {
            actor.should(seeThat("login error message", ErrorMessageQuestion.value(), equalTo(expectedMessage)));
        }
    }
} 