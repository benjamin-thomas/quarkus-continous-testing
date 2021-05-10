package app.repositories;

import app.entities.Fruit;
import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class FruitRepositoryTest {

    @Inject
    FruitRepository fruitRepository;

    @Test
    public void It_has_a_valid_setup() {
        assertNotNull(fruitRepository);
        assertThat("I have a valid database setup before going further", true);
    }

    @Test
    @Transactional
    public void It_should_load_a_valid_test_config() {

        Fruit apple = new Fruit("Apple");
        fruitRepository.persist(apple);
        List<Fruit> fruits = fruitRepository.listAll(); // Need database

        assertEquals(-1, fruits.size());
    }

    /*
    https://quarkus.io/guides/getting-started-testing
       @InjectMock
    GreetingService greetingService;

    @Test
    public void testGreeting() {
        when(greetingService.greet()).thenReturn("hi");
        given()
                .when().get("/greeting")
                .then()
                .statusCode(200)
                .body(is("hi"));
    }
     */
}
