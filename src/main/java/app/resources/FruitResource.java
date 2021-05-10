package app.resources;

import app.entities.Fruit;
import app.services.FruitService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/fruits")
public class FruitResource {

    @Inject
    FruitService fruitService;

    @GET
    public List<Fruit> hello() {
        return fruitService.getAll();
    }
}
