package com.inpost.qa.inpost.endpoints;

import com.inpost.qa.config.Endpoint;
import com.inpost.qa.config.Protocol;
import com.inpost.qa.session.Session;
import io.restassured.response.Response;

public class ShowMePaczkomatyEndpoint extends Endpoint {

    private static final String PATH = "/v1/points?{LOCATION}";
    private static final Protocol PROTOCOL = Protocol.https;

    public ShowMePaczkomatyEndpoint() {
        super(PATH, PROTOCOL);
    }

    public Response getList(Session session) {
        return get(session);
    }
}
