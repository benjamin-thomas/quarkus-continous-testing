package app.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class FruitResourceTest {

    @Test
    public void it_works() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void list_fruits() {
        given()
                .when().get("/fruits")
                .then()
                .statusCode(200);
    }

}
