package fi.academy.javavk7groupback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class RecipeController {
    @Autowired
    private RecipeRepository rr;

    @GetMapping ("/recipes")
    private Iterable<Recipe> getAllRecipes(){
        return rr.findAll();
    }
    @GetMapping("/recipes/{id}")
    public Optional<Recipe> getRecipeWithId(@PathVariable(name="id", required = true) Integer id) {
        return rr.findById(id);
    }
    @DeleteMapping("/recipes/{id}")
    public void deleteRecipeWithId (@PathVariable(name="id", required = true) Integer id) {
        rr.deleteById(id);
    }
    @PostMapping("/recipes")
    public void postRecipe(@RequestBody Recipe recipe) {
        rr.save(recipe);
    }
    @PutMapping("/recipes/{id}")
    public void putRecipeWithId(@PathVariable(name="id", required = true) Integer id, @RequestBody Recipe recipe) {
        rr.save(recipe);
    }

    @GetMapping("/recipes/fullrecipes")
    public Iterable<Recipe> getAllFullRecipes() {
        return rr.getFullRecipes();
    }

}
