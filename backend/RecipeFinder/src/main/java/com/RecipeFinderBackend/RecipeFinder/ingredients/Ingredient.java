package com.RecipeFinderBackend.RecipeFinder.ingredients;

import com.RecipeFinderBackend.RecipeFinder.ingredientcategories.IngredientCategory;
import com.RecipeFinderBackend.RecipeFinder.recipeingredients.RecipeIngredients;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "ingredients")
@Entity(name="Ingredients")
public class Ingredient {
    @Id
    @SequenceGenerator(
            name = "ingredient_sequence",
            sequenceName = "ingredient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ingredient_sequence"
    )
    @Column(
            name= "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "ingredient_name",
            updatable = true,
            unique = true
    )
    private String ingredientName;

    @ManyToOne
    @JoinColumn(name = "ingredient_category_id")
    private IngredientCategory ingredientCategory;


    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "ingredient"
    )
    private List<RecipeIngredients> recipeIngredients = new ArrayList<>();



    // constructor
    public Ingredient() {}

    public Ingredient(String ingredientName, IngredientCategory ingredientCategory) {
        this.ingredientName = ingredientName;
        this.ingredientCategory = ingredientCategory;
    }

    // setter methods
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public void setIngredientCategory(IngredientCategory ingredientCategory) {
        this.ingredientCategory = ingredientCategory;
    }

    // getter methods
    public String getIngredientName() {
        return ingredientName;
    }

//    public Long getIngredientId() {
//        return ingredientId;
//    }

    public IngredientCategory getIngredientCategory() {
        return ingredientCategory;
    }
}
