package fi.academy.javavk7groupback;

import java.util.List;
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
    @Autowired
    private IngredientRepository ir;

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

    @GetMapping("/ingredients")
    private Iterable<Ingredient> getAllIngredients(){
        return ir.findAll();
    }

    @DeleteMapping("/ingredients/{id}")
    public void deleteIngredientWithId (@PathVariable(name="id", required = true) Integer id) {
        ir.deleteById(id);
    }

    @PostMapping("/ingredients")
    public void postIngredient(@RequestBody Ingredient ingredient) {
        ir.save(ingredient);
    }

    @PutMapping("/ingredients/{id}")
    public void putIngredientWithId(@PathVariable(name="id", required = true) Integer id, @RequestBody Ingredient ingredient) {
        ir.save(ingredient);
    }

    @GetMapping("/ingredients/{id}")
    public Optional<Ingredient> getIngredientsWithId(@PathVariable(name="id", required = true) Integer id) {
        return ir.findById(id);
    }

    @GetMapping("/ingredientsbycode{koodi}")
    public Iterable<Recipe> getIngredientsWithCode(@RequestParam(name="koodi", required = true) Integer koodi) {
        return rr.getIngredientsByCode(koodi);
    }

    @PostMapping("/ingredientlist")
    public void postIngredientList(@RequestBody Ingredient[] ingredientList){
        List<Recipe> list = rr.findAllByIdNotNullOrderByIdDesc();
        Recipe last = list.get(0);
        for(Ingredient i : ingredientList){
            i.setRecipe(last);
            ir.save(i);
        }
    }






}
