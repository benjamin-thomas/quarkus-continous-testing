package app.resources;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

/*
Also see the helloURL test at:
    src/test/java/app/StaticContentTest.java
 */
@QuarkusTest
@TestHTTPEndpoint(GreetingResource.class)
class GreetingResourceTest {

    @Test
    public void It_serves_a_text_file() {
        given()
                .when().get() // goes to '/hello' thanks to @TestHTTPEndpoint
                .then()
                .body(is("Hello world!"));
    }

}
