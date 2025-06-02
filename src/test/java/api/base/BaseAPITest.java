package api.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseAPITest {

    //Initializes the base configuration for API tests by setting the base URI,API key and Content Type
    @BeforeClass
    public static void setup() {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .addHeader("x-api-key", "reqres-free-v1")
                .addHeader("Content-Type", "application/json")
                .build();

        RestAssured.requestSpecification = requestSpec;

    }
}
