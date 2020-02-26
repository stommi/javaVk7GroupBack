package fi.academy.javavk7groupback;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "recipe_recipe_id_seq")
    @SequenceGenerator(name = "recipe_recipe_id_seq",
            sequenceName = "recipe_recipe_id_seq",
            allocationSize = 1)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(name = "preparation_time")
    private Integer preparationTime;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column (name= "preparation_instructions")
    private String preparationInstructions;



}