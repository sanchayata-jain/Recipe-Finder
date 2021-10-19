package com.RecipeFinderBackend.RecipeFinder.recipeingredients;

import com.RecipeFinderBackend.RecipeFinder.ingredients.Ingredient;
import com.RecipeFinderBackend.RecipeFinder.recipe.Recipe;

import javax.persistence.*;

@Table(name = "recipe_ingredients")
@Entity(name="RecipeIngredients")
public class RecipeIngredients {

    @EmbeddedId
    private RecipeIngredientsId recipeIngredientsId = new RecipeIngredientsId();

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(
            name = "ingredient_id"
    )
    private Ingredient ingredient;


    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(
            name = "recipe_id"
    )
    private Recipe recipe;


    @Column(
            name = "measurement_type",
            nullable = false
    )
    private String measurementType;

    @Column(
            name = "measurement_qty",
            nullable = false
    )
    private Double measurementQuantity;

    // Constructors
    public RecipeIngredients() {}

    public RecipeIngredients(Ingredient ingredient, Recipe recipe,
                             String measurementType, Double measurementQuantity) {

        this.ingredient = ingredient;
        this.recipe = recipe;
        this.measurementType = measurementType;
        this.measurementQuantity = measurementQuantity;
    }

    // Methods


    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    public void setMeasurementQuantity(Double measurementQuantity) {
        this.measurementQuantity = measurementQuantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public Double getMeasurementQuantity() {
        return measurementQuantity;
    }

}
