package fi.academy.javavk7groupback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {
    @Autowired
    private RecipeRepository rr;

    @GetMapping ("/recipes/")
    private List<Recipe> getAllRecipes(){
        return (List<Recipe>) rr.findAll();
    }

}
