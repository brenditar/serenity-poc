package com.example.api.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

/**
 * Screenplay Question: Get the response code from the last API call.
 */
public class ResponseCodeQuestion implements Question<Integer> {
    public static ResponseCodeQuestion value() {
        return new ResponseCodeQuestion();
    }

    @Override
    public Integer answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
} 