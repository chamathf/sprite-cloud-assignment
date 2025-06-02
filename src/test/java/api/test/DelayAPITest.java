package api.test;

import api.base.BaseAPITest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DelayAPITest extends BaseAPITest {
    // This test verifies the API response time and correctness when a delay parameter is applied
    @Test
    public void testResponseTimeWithRestAssured() {
        given()
                .queryParam("delay", 3)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all()
                .time(lessThanOrEqualTo(5000L), TimeUnit.MILLISECONDS)
                .body("page", equalTo(1))
                .body("per_page", equalTo(6));
    }
}
