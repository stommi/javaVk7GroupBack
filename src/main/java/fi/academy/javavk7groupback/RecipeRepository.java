package fi.academy.javavk7groupback;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    @Query("SELECT i FROM Recipe r JOIN Ingredient i on i.recipe.id = r.id")
    Iterable<Recipe> getFullRecipes();

    @Query("SELECT i.name, i.amount, i.unit FROM Recipe r JOIN Ingredient i on i.recipe.id = r.id where i.recipe.id = :koodi")
    Iterable<Recipe> getIngredientsByCode(@Param("koodi") Integer koodi);

}


//"SELECT i.recipe.name, i.recipe.preparationInstructions, i.recipe.preparationTime, i.name, i.amount, i.unit FROM Recipe r JOIN Ingredient i on i.recipe.id = r.id"

//    SELECT recipe.name, preparation_instructions, preparation_time, ingredient.name,
//        ingredient.amount, ingredient.unit FROM recipe JOIN ingredient ON ingredient.recipe_fk = recipe.id;

