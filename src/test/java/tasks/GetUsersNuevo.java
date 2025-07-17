package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public abstract class GetUsersNuevo implements Task {

    public final int page;

    public GetUsersNuevo(int page) {
        this.page = page;
    }

    public static Performable fromPage(int page) {
        return instrumented(GetUsersNuevo.class, page);
    }

    @Override
    public <T extends Actor> void performAs (T actor) {
        actor.attemptsTo(
                Get.resource("/users?page=" + page)
                        .with(requestSpecification
                                -> requestSpecification.contentType(ContentType.JSON)
                                .header("x-api-key", "reqres-free-v1"))
        );
    }
}
