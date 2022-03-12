package com.inpost.com.steps;

import com.inpost.com.inpost.sendRequests.ShowMePaczkomaty;
import com.inpost.com.session.Session;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonSteps {

    private final Session session;
    private final ShowMePaczkomaty showMePaczkomaty;
    private Response response;

    public CommonSteps(Session session, ShowMePaczkomaty showMePaczkomaty) {
        this.showMePaczkomaty = showMePaczkomaty;
        this.session = session;
    }

    @Given("^Lista paczkomatów jest widoczna$")
    public void inPostListIsVisible() {
        response = showMePaczkomaty.request(session);

    }
}
