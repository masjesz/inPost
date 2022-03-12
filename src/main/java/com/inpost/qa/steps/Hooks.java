package com.inpost.qa.steps;

import com.inpost.qa.session.SessionHeaders;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;

public class Hooks {

    @Before
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.config().headerConfig(new HeaderConfig().overwriteHeadersWithName(
                SessionHeaders.HOST.getHeaderName()));
    }

    @After
    public void tearDown() {

    }
}
