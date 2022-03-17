package com.inpost.qa.steps;

import com.inpost.qa.inpost.client.InPostClient;
import com.inpost.qa.inpost.responses.getPaczkomatyResponse.GetPaczkomatyItemsResponse;
import com.inpost.qa.inpost.utils.Paczkomaty;
import com.inpost.qa.session.Session;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.Data;

import static org.assertj.core.api.Assertions.assertThat;

@Data
public class CommonSteps {

    final Session session;
    Response response;
    final InPostClient client;

    public CommonSteps(Session session, InPostClient client) {
        this.session = session;
        this.client = client;
    }

    @Given("Mam listę paczkomatów")
    public void inPostListIsVisible() {
        response = client.getPaczkomatyList(session);
        assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @When("Zapisuje listę adresów do pliku")
    public void writeAddressListToFile() {
        Paczkomaty.getPaczkomatyAssert(response).searchAddressesInResponse();
    }

    @Then("Wszystkie paczkomaty mają poprawny adres")
    public void wszystkiePaczkomatyMajaAdres() {
        GetPaczkomatyItemsResponse response = session.getLastResponse().as(GetPaczkomatyItemsResponse.class);
        assertThat(response).isNotNull();
        response.getItems().forEach(i -> assertThat(i.getAddress_details().getCity()).contains("Warszawa"));
        response.getItems().forEach(i -> assertThat(
                i.getAddress_details().getStreet()
                        + " "
                        + i.getAddress_details().getBuilding_number())
                .containsPattern("^((.)+(\\d)+(.)*)$"));
        response.getItems().forEach(i -> assertThat(i.getAddress_details().getPost_code()).containsPattern("(\\d{2}-?\\d{3})"));
    }
}
