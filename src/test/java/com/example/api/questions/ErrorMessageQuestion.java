package com.example.api.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

/**
 * Screenplay Question: Get the error message from the last API response.
 */
public class ErrorMessageQuestion implements Question<String> {
    public static ErrorMessageQuestion value() {
        return new ErrorMessageQuestion();
    }

    @Override
    public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return SerenityRest.lastResponse().jsonPath().getString("error");
    }
} 