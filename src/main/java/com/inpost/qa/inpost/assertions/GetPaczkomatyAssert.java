package com.inpost.qa.inpost.assertions;

import com.inpost.qa.inpost.responses.GetPaczkomatyListResponse;
import com.inpost.qa.session.Session;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import java.util.List;

public class GetPaczkomatyAssert extends AbstractAssert<GetPaczkomatyAssert, Response> {
    private GetPaczkomatyAssert(Response actual) {super(actual, GetPaczkomatyAssert.class);}

    public static GetPaczkomatyAssert getPaczkomatyAssert(Response actual) {
        return new GetPaczkomatyAssert(actual);
    }


    public void containProvidedAddress(Session session) {
        List<String> searchAddresses = searchAddressesInResponse();
        Assertions.assertThat(searchAddresses).contains("Warszawa");
    }

    public List<String> searchAddressesInResponse() {
        GetPaczkomatyListResponse getPaczkomatyListResponse = GetPaczkomatyListResponse.from(this.actual);
        return getPaczkomatyListResponse.getItems();
    }
}
