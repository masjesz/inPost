package com.inpost.qa.inpost.responses;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetPaczkomatyListResponse {

    public final JsonNode response;

    public static GetPaczkomatyListResponse from(Response response) {
        return new GetPaczkomatyListResponse(response.as(JsonNode.class));
    }

    private GetPaczkomatyListResponse(JsonNode responseNode) {
        this.response = responseNode;
    }

    public List<String> getItems() {
        JsonNode items = response.get("items");
        List<String> addresses = new ArrayList<>();
        if (items !=null) {
            addresses = IntStream.range(0, 10).mapToObj(
                            items::get)
                    .map(JsonNode::asText).collect(Collectors.toList());
        }
return Collections.unmodifiableList(addresses);
    }
}

