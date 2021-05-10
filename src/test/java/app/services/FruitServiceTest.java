package app.services;

import app.entities.Fruit;
import app.repositories.FruitRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class FruitServiceTest {

    @Inject
    FruitService fruitService;

    @InjectMock
    FruitRepository fruitRepository;

    @Test
    public void it_works() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void It_returns_many_fruits() {
        List<Fruit> twoFruits = List.of(
                new Fruit("Apple"),
                new Fruit("Orange")
        );

        Mockito.when(fruitRepository.listAll())
                .thenReturn(twoFruits);

        assertEquals(twoFruits, fruitService.getAll());

    }

}
