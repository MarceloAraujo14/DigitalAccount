package br.com.digitalaccount;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.client.Entity.json;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AccountResourceTest {

//    @Test
    public void testHelloEndpoint() {

        given()
          .when().get("/accounts")
          .then()
             .statusCode(200)
             .body(is("{\"message\":\"Hello RESTEasy\"}"));
    }

}