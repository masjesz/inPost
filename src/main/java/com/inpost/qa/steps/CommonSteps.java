package com.inpost.qa.steps;

import com.inpost.qa.inpost.sendRequests.ShowMePaczkomaty;
import com.inpost.qa.session.Session;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonSteps {

    final Session session;
    final ShowMePaczkomaty showMePaczkomaty;

    public CommonSteps(Session session, ShowMePaczkomaty showMePaczkomaty) {
        this.session = session;
        this.showMePaczkomaty = showMePaczkomaty;
    }


    @Given("Lista paczkomatów jest widoczna")
    public void inPostListIsVisible() {
        Response response = showMePaczkomaty.request(session);
        throw new io.cucumber.java.PendingException();
    }

    @When("test")
    public void test() {
    }
}
