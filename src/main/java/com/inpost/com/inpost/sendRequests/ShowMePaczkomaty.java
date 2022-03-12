package com.inpost.com.inpost.sendRequests;

import com.inpost.com.session.Session;
import com.inpost.com.inpost.client.InPostClient;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShowMePaczkomaty {

    private final InPostClient client;

    public Response request(Session session) {

        return client.getPaczkomatyList(session);
    }
}
