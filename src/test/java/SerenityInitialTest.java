import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.notNullValue;


public class SerenityInitialTest {

    private static final String restApiUrl = "https://reqres.in/api";

/*
    public void getUsers() {
        Actor brenda = Actor.named("Brenda")
                .whoCan(CallAnApi.at(restApiUrl));

        brenda.attemptsTo(
                GetUsersNuevo.fromPage(1)
        );

        brenda.should(
                seeThat("el codigo de respuesta", ResponseCode.was(), equalTo(200))
        );

       DataItem user = new GetUsersQuestion().answeredBy(brenda)
                .getData().stream().filter(x -> x.getId() == 1).findFirst().orElse(null);

        brenda.should(
                seeThat("usuario no es nulo", act -> user, notNullValue())
        );

        brenda.should(
                seeThat("el email del usuario",
                        act -> user.getEmail(), equalTo("george.bluth@reqres.in")),
                seeThat("el avatar del usuario",
                        act -> user.getAvatar(), equalTo("https://reqres.in/img/faces/1-image.jpg"))
        );
    }

    public void registerUserTest() {
        Actor brenda = Actor.named("Brenda")
                .whoCan(CallAnApi.at(restApiUrl));

        RegisterUserRequest user = new RegisterUserRequest("eve.holt@reqres.in", "pistol");

        brenda.attemptsTo(
                RegisterUser.withInfo(user)
        );

        brenda.should(
                seeThat("el codigo de respuesta", ResponseCode.was(), equalTo(200))
        );
    }

 */
}

