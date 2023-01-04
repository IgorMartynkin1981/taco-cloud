package ru.martynkin.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.martynkin.tacocloud.Ingredient;

public interface IngredientRepository
         extends CrudRepository<Ingredient, String> {
}
