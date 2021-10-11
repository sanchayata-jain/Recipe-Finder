package com.RecipeFinderBackend.RecipeFinder.recipeingredients;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RecipeIngredientsId
        implements Serializable {

    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(name = "ingredient_id")
    private Long ingredientId;

    // Constructors
    public RecipeIngredientsId() {}

    public RecipeIngredientsId(Long recipeId, Long ingredientId) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
    }

    // Methods

    public Long getIngredientId() {
        return ingredientId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public String toString() {
        return "RecipeIngredientsId{" +
                "recipeId=" + recipeId +
                ", ingredientId=" + ingredientId +
                '}';
    }


}
