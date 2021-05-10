package app.resources;

import app.entities.Fruit;
import app.services.FruitService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class FruitResourceTest {

    @InjectMock
    FruitService fruitService;

    @Test
    public void it_works() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void list_fruits() {
        List<Fruit> twoFruits = List.of(
                new Fruit("Pears"),
                new Fruit("Bananas")
        );
        Mockito.when(fruitService.getAll())
                .thenReturn(twoFruits);

        given()
                .when().get("/fruits")
                .then()
                .statusCode(200)
                .body(
                        "[0].name", is("Pears"),
                        "[1].name", is("Bananas")
                );
    }

}
