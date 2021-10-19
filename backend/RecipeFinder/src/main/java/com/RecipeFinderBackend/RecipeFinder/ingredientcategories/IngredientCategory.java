package com.RecipeFinderBackend.RecipeFinder.ingredientcategories;

import com.RecipeFinderBackend.RecipeFinder.ingredients.Ingredient;

import javax.persistence.*;
import java.util.List;


@Table(name = "ingredient_categories")
@Entity(name = "IngredientCategory")
public class IngredientCategory {
    @Id
    @SequenceGenerator(
            name = "ingredient_category_sequence",
            sequenceName = "ingredient_category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ingredient_category_sequence"
    )
    @Column(
            name= "ingredient_category_id",
            updatable = false
    )
    private int ingredientCategoryId;

    @Column(
            name = "ingredient_category_name",
            updatable = true,
            unique = true
    )
    private String ingredientCategoryName;


    @OneToMany(mappedBy = "ingredientCategory")
    private List<Ingredient> ingredients;


    // constructors
    public IngredientCategory() {}

    public IngredientCategory(String ingredientCategoryName) {

        this.ingredientCategoryName = ingredientCategoryName;
    }


    public void setIngredientCategoryName(String ingredientCategoryName) {
        this.ingredientCategoryName = ingredientCategoryName;
    }

    public int getIngredientCategoryId() {

        return ingredientCategoryId;
    }

    public String getIngredientCategoryName() {

        return ingredientCategoryName;
    }

}
