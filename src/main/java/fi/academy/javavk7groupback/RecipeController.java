package fi.academy.javavk7groupback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RecipeController {
    @Autowired
    private RecipeRepository rr;

    @GetMapping ("/recipes/")
    private Iterable<Recipe> getAllRecipes(){
        return rr.findAll();
    }

}
