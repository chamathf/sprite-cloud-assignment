package api.test;

import api.base.BaseAPITest;
import api.utils.JsonFileReader;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.*;


public class NegativeAPITest extends BaseAPITest {
    //Test to verify that login API returns an error when the password is missing in the request.
    @Test
    public void testLoginMissingPassword() throws Exception {
        String requestBody = JsonFileReader.getPayloadByName("login_payloads.json", "missing_password");
        given()
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .log().body()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }

    //Test to verify that registration API returns an error when the password is missing in the request.
    @Test
    public void testRegistrationMissingPassword() throws Exception {
        String requestBody = JsonFileReader.getPayloadByName("login_payloads.json", "registration_missing_password");
        given()
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }

    //Test to verify that fetching a single user with a non-existent userId
    @Test
    public void testGetSingleUserNotFound() {
        given()
                .pathParam("userId", 23)
                .when()
                .get("/api/unknown/{userId}")
                .then()
                .log().all()
                .statusCode(404)
                .body("", is(emptyMap()));
    }


}
