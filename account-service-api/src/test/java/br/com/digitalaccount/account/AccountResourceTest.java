package br.com.digitalaccount.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public
class AccountResourceTest {

    @Test
    void getAllAccountTest() throws JsonProcessingException {

        String json = "[{\"accountBranch\":1,\"accountNumber\":123456,\"balance\":500.0,\"datCreation\":\"2020-05-25T00:10:00\",\"id\":0}]";

        given()
          .when().get("/accounts")
          .then()
             .statusCode(200)
             .body(is(json));
    }

}