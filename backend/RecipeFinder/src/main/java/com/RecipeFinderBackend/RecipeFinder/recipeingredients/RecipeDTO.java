package com.RecipeFinderBackend.RecipeFinder.recipeingredients;
import com.RecipeFinderBackend.RecipeFinder.ingredients.Ingredient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeDTO {
    private String name;
    private String recipeDescription;
//    private List<Ingredient> ingredients;
    private String difficulty;
    private String recipeAuthor;

    // Constructors
    public RecipeDTO() {}

    public RecipeDTO(String name, String recipeDescription,
                     String difficulty, String recipeAuthor) {
        this.name = name;
        this.recipeDescription = recipeDescription;
        this.difficulty = difficulty;
        this.recipeAuthor= recipeAuthor;
    }

    // Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

//    public List<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(List<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getRecipeAuthor() {
        return recipeAuthor;
    }

    public void setRecipeAuthor(String recipeAuthor) {
        this.recipeAuthor = recipeAuthor;
    }
}