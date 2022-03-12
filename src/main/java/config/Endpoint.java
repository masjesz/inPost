package config;

import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.response.Response;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import session.Session;

import java.io.IOException;
import java.net.URL;

import static io.restassured.RestAssured.with;

public abstract class Endpoint {

    final Logger logger = LoggerFactory.getLogger(Endpoint.class);
    protected String path;
    protected Protocol protocol;
    protected Response lastResponse;
    private URL url;

    @Getter
    protected final ObjectMapper om;

    protected Endpoint(String path, Protocol protocol) {
        this.path = path;
        this.protocol = protocol;
        this.om = new ObjectMapper();
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public URL getURL() {
        if (url == null) {
            try {
                url = new URL(protocol.toString(), "inpost.pl", path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    protected Response get(Session session) {
        lastResponse = with()
                .spec(session.getRequestSpecBuilder().setRelaxedHTTPSValidation().build())
                .get(getURL());
        logger.debug(
                String.format("GET status: %s, response: %s", lastResponse.statusCode(), lastResponse.asString()));

        return lastResponse;
    }
}
