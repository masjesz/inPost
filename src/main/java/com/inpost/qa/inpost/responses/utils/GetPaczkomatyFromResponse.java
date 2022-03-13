package com.inpost.qa.inpost.responses.utils;

import com.inpost.qa.inpost.responses.GetPaczkomatyListResponse;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class GetPaczkomatyFromResponse {


    private Response response;

    public static GetPaczkomatyFromResponse getPaczkomatyAssert(Response response) {
        return new GetPaczkomatyFromResponse(response);
    }

    public void searchAddressesInResponse() {
        GetPaczkomatyListResponse getPaczkomatyListResponse = GetPaczkomatyListResponse.from(response);
        getPaczkomatyListResponse.fileWriter();
    }

}
