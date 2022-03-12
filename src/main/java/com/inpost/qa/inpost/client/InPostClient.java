package com.inpost.qa.inpost.client;

import com.inpost.qa.session.Session;
import com.inpost.qa.inpost.endpoints.ShowMePaczkomatyEndpoint;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@AllArgsConstructor
public class InPostClient {

    public static final String FIELDS = "fields=name%2Ctype%2Clocation%2Caddress%2Caddress_details%2Cfunctions%2Clocation_date%2Copening_hours%2Clocation_247%2Capm_doubled%2Cimage_url%2Ceasy_access_zone%2Cpartner_id&status=Operating%2COverloaded%2CNonOperating&type=parcel_locker_superpop%2Cparcel_locker&functions=parcel_collect&relative_point=52.20549410415984%2C20.985088374582123&max_distance=4611.60803138419&limit=200&source=geov4_pl";
    final ShowMePaczkomatyEndpoint showMePaczkomatyEndpoint;

    @SneakyThrows
    public Response getPaczkomatyList(Session session) {

        session.getRequestSpecBuilder().addPathParam("LOCATION", URLDecoder.decode(FIELDS, StandardCharsets.UTF_8.name()));
        return showMePaczkomatyEndpoint.getList(session);
    }
}
