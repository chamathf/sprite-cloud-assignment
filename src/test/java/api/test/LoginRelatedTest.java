package api.test;

import api.base.BaseAPITest;
import api.utils.JsonFileReader;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class LoginRelatedTest extends BaseAPITest {

    //This test verifies successful login functionality of the API.
    @Test
    public void testLoginSuccessful() throws IOException {
        String requestBody = JsonFileReader.getPayloadByName("login_payloads.json", "valid_login");

        given()
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(200)
                .body("token", not(emptyOrNullString()));
    }
}