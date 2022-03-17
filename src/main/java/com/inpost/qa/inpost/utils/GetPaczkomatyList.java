package com.inpost.qa.inpost.utils;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetPaczkomatyList {

    public final JsonNode response;
    final static String outputFilePath
            = "C:\\Dev\\inPost-API\\src\\main\\resources\\file.txt";

    public static GetPaczkomatyList from(Response response) {
        return new GetPaczkomatyList(response.as(JsonNode.class));
    }

    private GetPaczkomatyList(JsonNode responseNode) {
        this.response = responseNode;
    }

    public Map<String, String> getLineAddresses() {
        JsonNode items = response.get("items");
        List<String> addresses = new ArrayList<>();
        List<String> addresses2 = new ArrayList<>();
        if (items != null) {
            addresses = getLine(items, "line2");
            addresses2 = getLine(items, "line1");
        }

        return MapsKt.toMap(CollectionsKt.zip(addresses, addresses2));
    }

    @SneakyThrows
    public void fileWriter() {
        HashMap<String, String> map
                = new HashMap<>(getLineAddresses());

        File file = new File(outputFilePath);

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, String> entry :
                    map.entrySet()) {
                bf.write(entry.getKey() + " "
                        + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        }
    }


    private List<String> getLine(JsonNode items, String line) {
        return IntStream.range(0, 10)
                .mapToObj((int child) -> items.get(child).get("address").get(line))
                .map(JsonNode::asText)
                .collect(Collectors.toList());
    }
}

