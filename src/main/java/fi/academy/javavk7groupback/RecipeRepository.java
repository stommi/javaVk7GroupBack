package fi.academy.javavk7groupback;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    @Query("SELECT r FROM Recipe r")
    Iterable<Recipe> getFullRecipes();
}
