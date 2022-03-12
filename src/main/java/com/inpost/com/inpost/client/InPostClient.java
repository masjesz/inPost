package com.inpost.com.inpost.client;

import com.inpost.com.session.Session;
import com.inpost.com.inpost.endpoints.ShowMePaczkomatyEndpoint;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InPostClient {

    final ShowMePaczkomatyEndpoint showMePaczkomatyEndpoint;

    public Response getPaczkomatyList(Session session) {
        return showMePaczkomatyEndpoint.getList(session);
    }
}
