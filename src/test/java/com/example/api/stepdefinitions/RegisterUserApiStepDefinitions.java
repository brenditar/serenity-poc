package com.example.api.stepdefinitions;

import com.example.api.questions.ErrorMessageQuestion;
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

    @Given("the API for registration is available")
    public void the_api_for_registration_is_available() {
        actor = Actor.named("API Tester").whoCan(CallAnApi.at(API_URL));
    }

    @When("I register a user with email {string} and password {string} via API")
    public void i_register_a_user_with_email_and_password_via_api(String email, String password) {
        User user = new User.Builder()
                .email(email)
                .password(password)
                .build();
        actor.attemptsTo(RegisterUserApiTask.with(user.getEmail(), user.getPassword()));
    }

    @When("I register a user with email {string} and no password via API")
    public void i_register_a_user_with_email_and_no_password_via_api(String email) {
        User user = UserFactory.createUserWithEmail(email);
        actor.attemptsTo(RegisterUserApiTask.withNoPassword(user.getEmail()));
    }

    @Then("the registration response code should be {int}")
    public void the_registration_response_code_should_be(Integer code) {
        actor.should(seeThat("registration response code", ResponseCodeQuestion.value(), equalTo(code)));
    }

    @Then("the registration error message should be {string}")
    public void the_registration_error_message_should_be(String expectedMessage) {
        actor.should(seeThat("registration error message", ErrorMessageQuestion.value(), equalTo(expectedMessage)));
    }
} 