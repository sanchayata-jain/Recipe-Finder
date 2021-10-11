//package com.RecipeFinderBackend.RecipeFinder.reciperequirements;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import java.io.Serializable;
//
//@Embeddable
//public class RecipeRequirementId implements Serializable {
//
//    @Column(name = "recipe_id",
//            insertable = false,
//            updatable = true)
//    private Long recipeId;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "recipe_requirement",
//            insertable = false,
//            updatable = false)
//    private Requirements recipeRequirement;
//
//    // Constructors
//    public RecipeRequirementId() {}
//
//    public RecipeRequirementId(Long recipeId, Requirements recipeRequirement) {
//        this.recipeId = recipeId;
//        this.recipeRequirement = recipeRequirement;
//    }
//
//    // methods
//    public Long getRecipeId() {
//        return recipeId;
//    }
//
//    public Requirements getRecipeRequirement() {
//        return recipeRequirement;
//    }
//
//    public void setRecipeId(Long recipeId) {
//        this.recipeId = recipeId;
//    }
//
//    public void setRecipeRequirement(Requirements recipeRequirement) {
//        this.recipeRequirement = recipeRequirement;
//    }
//}
