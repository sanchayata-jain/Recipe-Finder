//package com.RecipeFinderBackend.RecipeFinder.reciperequirements;
//
//import com.RecipeFinderBackend.RecipeFinder.recipe.Recipe;
//
//import javax.persistence.*;
//
//@Table(name = "recipe_requirements")
//@Entity(name="RecipeRequirement")
//public class RecipeRequirement {
//
//    @EmbeddedId
//    private RecipeRequirementId recipeRequirementId = new RecipeRequirementId();
//
//    @ManyToOne
//    @JoinColumn(
//            name = "recipe_id"
//    )
//    private Recipe recipe;
//
//
//    @Enumerated(EnumType.STRING)
//    @Column (
//            name = "recipe_requirement"
//    )
//    private Requirements recipeRequirement;
//
//
//    // Constructors
//    public RecipeRequirement() {}
//
//    public RecipeRequirement(Recipe recipe, Requirements recipeRequirement) {
//        this.recipe = recipe;
//        this.recipeRequirement = recipeRequirement;
//    }
//
//
//    // Methods
//    public void setRecipe(Recipe recipe) {
//        this.recipe = recipe;
//    }
//
//    public void setRecipeRequirement(Requirements recipeRequirement) {
//        this.recipeRequirement = recipeRequirement;
//    }
//
//    public Recipe getRecipe() {
//        return recipe;
//    }
//
//    public Requirements getRecipeRequirement() {
//        return recipeRequirement;
//    }
//}
