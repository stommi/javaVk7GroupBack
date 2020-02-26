package fi.academy.javavk7groupback;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "ingredient_ingredient_id_seq")
    @SequenceGenerator(name = "ingredient_ingredient_id_seq",
            sequenceName = "ingredient_ingredient_id_seq",
            allocationSize = 1)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String name;
    private Integer amout;
    private String unit;
    @ManyToOne
    @JoinColumn(name = "recipe_fk")
    private Recipe recipe;

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

    public Integer getAmout() {
        return amout;
    }

    public void setAmout(Integer amout) {
        this.amout = amout;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}

