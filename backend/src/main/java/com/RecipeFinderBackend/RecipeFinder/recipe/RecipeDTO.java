//package com.RecipeFinderBackend.RecipeFinder.recipe;
//
//import com.RecipeFinderBackend.RecipeFinder.ingredients.Ingredients;
//import com.RecipeFinderBackend.RecipeFinder.users.User;
//
//import java.time.LocalTime;
//import java.util.List;
//
//public class RecipeDTO {
//    private String name;
//    private String recipeDescription;
//    private List<Ingredients> ingredients;
//    private MealRequirements mealRequirements;
//    private LocalTime time;
//    private String difficulty;
//    private int rating;
//    private User user;
//
//    public RecipeDTO(String name, String recipeDescription, List<Ingredients> ingredients,
//                     MealRequirements mealRequirements, LocalTime time,
//                     String difficulty, int rating, User user) {
//        this.name = name;
//        this.recipeDescription = recipeDescription;
//        this.ingredients = ingredients;
//        this.mealRequirements = mealRequirements;
//        this.time = time;
//        this.difficulty = difficulty;
//        this.rating = rating;
//        this.user= user;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getRecipeDescription() {
//        return recipeDescription;
//    }
//
//    public void setRecipeDescription(String recipeDescription) {
//        this.recipeDescription = recipeDescription;
//    }
//
//    public List<Ingredients> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(List<Ingredients> ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    public MealRequirements getMealRequirements() {
//        return mealRequirements;
//    }
//
//    public void setMealRequirements(MealRequirements mealRequirements) {
//        this.mealRequirements = mealRequirements;
//    }
//
//    public LocalTime getTime() {
//        return time;
//    }
//
//    public void setTime(LocalTime time) {
//        this.time = time;
//    }
//
//    public String getDifficulty() {
//        return difficulty;
//    }
//
//    public void setDifficulty(String difficulty) {
//        this.difficulty = difficulty;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}