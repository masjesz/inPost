package com.inpost.qa.inpost.sendRequests;

import com.inpost.qa.session.Session;
import com.inpost.qa.inpost.client.InPostClient;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShowMePaczkomaty {

    private final InPostClient client;

    public Response request(Session session) {

        return client.getPaczkomatyList(session);
    }
}
