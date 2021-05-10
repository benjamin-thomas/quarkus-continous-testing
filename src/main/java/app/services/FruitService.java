package app.services;

import app.entities.Fruit;
import app.repositories.FruitRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FruitService {
    @Inject
    FruitRepository fruitRepository;

    public List<Fruit> getAll() {
        if (fruitRepository == null) {
            System.out.println(">>> FRUIT REPO IS NULL!!!");
            throw new Error("FRUIT REPO NULL!!");
        }
        return fruitRepository.listAll();
    }
}
