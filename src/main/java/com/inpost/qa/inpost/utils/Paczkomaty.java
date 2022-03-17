package com.inpost.qa.inpost.utils;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class Paczkomaty {


    private Response response;

    public static Paczkomaty getPaczkomatyAssert(Response response) {
        return new Paczkomaty(response);
    }

    public void searchAddressesInResponse() {
        GetPaczkomatyList paczkomatyList = GetPaczkomatyList.from(response);
        paczkomatyList.fileWriter();
    }

}
