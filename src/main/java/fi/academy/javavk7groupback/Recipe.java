package fi.academy.javavk7groupback;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "recipe_recipe_id_seq")
    @SequenceGenerator(name = "recipe_recipe_id_seq",sequenceName = "recipe_recipe_id_seq",allocationSize = 1)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private Integer preparationTime;
    @Lob
    private String ingredients;
    @Lob
    private String preparationInstructions;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPreparationTime() {
        return preparationTime;
    }
    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }
    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public String getPreparationInstructions() {
        return preparationInstructions;
    }
    public void setPreparationInstructions(String preparationInstructions) {
        this.preparationInstructions = preparationInstructions;
    }
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", preparationTime=" + preparationTime +
                ", ingredients='" + ingredients + '\'' +
                ", preparationInstructions='" + preparationInstructions + '\'' +
                '}';
    }
}