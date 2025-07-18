package com.example.api.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.jetbrains.annotations.Nullable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Screenplay Task: Register a user via Reqres API.
 */
public class RegisterUserApiTask implements Task {
    private final String email;
    private final String password;

    public RegisterUserApiTask(String email, @Nullable String password) {
        this.email = email;
        this.password = password;
    }

    public static Performable with(String email, String password) {
        return instrumented(RegisterUserApiTask.class, email, password);
    }

    public static Performable withNoPassword(String email) {
        return instrumented(RegisterUserApiTask.class, email, null);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = password == null
                ? String.format("{\"email\":\"%s\"}", email)
                : String.format("{\"email\":\"%s\",\"password\":\"%s\"}", email, password);
        actor.attemptsTo(
                Post.to("/register")
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .header("x-api-key", "reqres-free-v1")
                                .body(body))
        );
    }
} 
