package com.inpost.qa.inpost.responses;


import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AbstractAssert;

@Slf4j
public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {


    private ResponseAssert(Response response) {
        super(response, ResponseAssert.class);
    }

    public static ResponseAssert assertThat(Response actual) {
        return new ResponseAssert(actual);
    }
}
