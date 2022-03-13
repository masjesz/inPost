package com.inpost.qa.steps;

import com.inpost.qa.inpost.responses.utils.GetPaczkomatyFromResponse;
import com.inpost.qa.inpost.sendRequests.ShowMePaczkomaty;
import com.inpost.qa.session.Session;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonSteps {

    final Session session;
    Response response;
    final ShowMePaczkomaty showMePaczkomaty;

    public CommonSteps(Session session, ShowMePaczkomaty showMePaczkomaty) {
        this.session = session;
        this.showMePaczkomaty = showMePaczkomaty;
    }

    @Given("Mam listę paczkomatów")
    public void inPostListIsVisible() {
        response = showMePaczkomaty.request(session);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);

    }

    @When("Zapisuje listę adresów do pliku")
    public void writeAddressListToFile() {
        GetPaczkomatyFromResponse.getPaczkomatyAssert(response).searchAddressesInResponse();
    }
}
