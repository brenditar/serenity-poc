package stepdefinitions;

import models.register.RegisterUserRequest;
import questions.ResponseCode;
import tasks.RegisterUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterUserStepDefinitions {

    private static final String restApiUrl = "https://reqres.in/api";
    private Actor brenda;

    @Given("Brenda is a client who wants to manage her banking products")
    public void brendaIsAClientWhoWantsToManageHerBankingProducts() {
        brenda = Actor.named("Brenda")
                .whoCan(CallAnApi.at(restApiUrl));
    }

    @When("she sends the required information for registration")
    public void sheSendsTheRequiredInformationForRegistration() {
        RegisterUserRequest user = new RegisterUserRequest("eve.holt@reqres.in", "pistol");
        brenda.attemptsTo(
                RegisterUser.withInfo(user)
        );
    }

    @Then("she should get a virtual account to log in whenever she needs")
    public void sheShouldGetAVirtualAccountToLogInWheneverSheNeeds() {
        brenda.should(
                seeThat("response code", ResponseCode.was(), equalTo(200))
        );
    }
}
