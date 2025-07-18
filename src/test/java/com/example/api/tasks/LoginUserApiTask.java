package com.example.api.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.jetbrains.annotations.Nullable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Screenplay Task: Login a user via Reqres API.
 */
public class LoginUserApiTask implements Task {
    private final String email;
    private final String password;

    public LoginUserApiTask(String email, @Nullable String password) {
        this.email = email;
        this.password = password;
    }

    public static Performable with(String email, String password) {
        return instrumented(LoginUserApiTask.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = password == null || password.isEmpty()
                ? String.format("{\"email\":\"%s\"}", email)
                : String.format("{\"email\":\"%s\",\"password\":\"%s\"}", email, password);
        actor.attemptsTo(
                Post.to("/login")
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(body))
        );
    }
} 