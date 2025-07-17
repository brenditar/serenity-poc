package questions;

import models.users.GetUsersResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUsersQuestion implements Question {

    @Override
    public GetUsersResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(GetUsersResponse.class);
    }
}
