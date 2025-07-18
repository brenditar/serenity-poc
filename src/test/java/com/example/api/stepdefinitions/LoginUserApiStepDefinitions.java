package com.example.api.stepdefinitions;

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

    @Given("the API is available")
    public void the_api_is_available() {
        actor = Actor.named("API Tester").whoCan(CallAnApi.at(API_URL));
    }

    @When("I login with email {string} and password {string}")
    public void i_login_with_email_and_password(String email, String password) {
        User user = new User.Builder()
                .email(email)
                .password(password)
                .build();
        actor.attemptsTo(LoginUserApiTask.with(user.getEmail(), user.getPassword()));
    }

    @Then("the response code should be {int}")
    public void the_response_code_should_be(Integer code) {
        actor.should(seeThat("response code", ResponseCodeQuestion.value(), equalTo(code)));
    }

    @Then("the error message should be {string}")
    public void the_error_message_should_be(String expectedMessage) {
        if (expectedMessage != null && !expectedMessage.isEmpty()) {
            actor.should(seeThat("error message", ErrorMessageQuestion.value(), equalTo(expectedMessage)));
        }
    }
} 