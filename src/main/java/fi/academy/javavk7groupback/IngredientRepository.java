package fi.academy.javavk7groupback;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface IngredientRepository extends CrudRepository <Ingredient, Integer> {
}
