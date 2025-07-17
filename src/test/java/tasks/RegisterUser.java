package tasks;

import interactions.Post;
import models.register.RegisterUserRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUser implements Task {

    private final RegisterUserRequest userInfo;

    public RegisterUser(RegisterUserRequest userInfo) {
        this.userInfo= userInfo;
    }

    public static Performable withInfo(RegisterUserRequest userInfo) {
        return instrumented(RegisterUser.class, userInfo);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/register")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("x-api-key", "reqres-free-v1")
                                .body(userInfo)
                        )
        );
    }
}
