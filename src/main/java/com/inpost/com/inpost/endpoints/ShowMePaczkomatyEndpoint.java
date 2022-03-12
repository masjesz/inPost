package com.inpost.com.inpost.endpoints;

import com.inpost.com.config.Endpoint;
import com.inpost.com.config.Protocol;
import com.inpost.com.session.Session;
import io.restassured.response.Response;

public class ShowMePaczkomatyEndpoint extends Endpoint {

    private static final String PATH = "/v1/points/{LOCATION???}"; //TODO: sprawdzić ten location
    private static final Protocol PROTOCOL = Protocol.https;

    protected ShowMePaczkomatyEndpoint() {
        super(PATH, PROTOCOL);
    }

    public Response getList(Session session) {
        return get(session);
    }
}
