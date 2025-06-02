package api.test;

import api.base.BaseAPITest;
import api.utils.JsonFileReader;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsMapContaining.hasEntry;


public class UserRelatedAPITest extends BaseAPITest {
    // Test to verify that the users listing API returns expected data
    @Test
    public void testListUsers() {
        given()
                .queryParam("page", 2)
                .when()
                .get("/users")
                .then()
                .log().body()
                .statusCode(200)
                .body("total", equalTo(12))
                .body("data[0]", hasEntry("id", 7))
                .body("data[0]", hasEntry("email", "michael.lawson@reqres.in"));

    }

    //Test to verify updating user details is successful
    @Test
    public void testUpdateUserSuccessful() throws Exception {
        String requestBody = JsonFileReader.getPayloadByName("update_payloads.json", "valid_update");

        given()
                .body(requestBody)
                .when()
                .put("/users/2")
                .then()
                .log().body()
                .log().ifValidationFails()
                .statusCode(200)
                .body("name", equalTo("norpheus"))
                .body("job", equalTo("zion resident"));

    }

    //Test to verify that deleting a user
    @Test
    public void testVerifyUserDeleted() {
        given()
                .pathParam("id", 2)
                .when()
                .delete("/api/users/{id}")
                .then()
                .log().all()
                .assertThat()
                .statusCode(204)
                .body(emptyString());
    }

    //Test to verify that login API returns error when password is missing.
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

}