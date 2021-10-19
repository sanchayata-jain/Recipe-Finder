package com.RecipeFinderBackend.RecipeFinder.recipe;

import com.RecipeFinderBackend.RecipeFinder.exceptions.NotAllowedToModify;
import com.RecipeFinderBackend.RecipeFinder.exceptions.NotFoundException;
import com.RecipeFinderBackend.RecipeFinder.recipeingredients.RecipeIngredients;
import com.RecipeFinderBackend.RecipeFinder.recipeingredients.RecipeIngredientsRepository;
import com.RecipeFinderBackend.RecipeFinder.recipeingredients.RecipeDTO;
import com.RecipeFinderBackend.RecipeFinder.users.User;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class RecipeService {

    @Autowired
    private final RecipeRepository recipeRepository;
    private final RecipeIngredientsRepository recipeIngredientsRepository;

    // Constructor
    public RecipeService(RecipeRepository recipeRepository,
                         RecipeIngredientsRepository recipeIngredientsRepository,
                         RecipeDTO recipeDTO) {

        this.recipeRepository = recipeRepository;
        this.recipeIngredientsRepository = recipeIngredientsRepository;
    }


        public List<Recipe> getAllRecipes() {
            // this method will only return details stored in the recipes table,
            // not any of the ingredients which are needed to make the recipe
            return recipeRepository.findAll();
        }

        public List<Quartet<String, String, String, List<Triplet<String, Double, String>>>> getMyRecipes(long userId) {
            List<Recipe> myRecipes = recipeRepository.findMyRecipes(userId);
            List<Quartet<String, String, String, List<Triplet<String, Double, String>>>> myRecipesDetails = new ArrayList<>();
            List<Triplet<String, Double, String>> ingredientsNames = new ArrayList<>();
            if (!myRecipes.isEmpty()) {
                for (Recipe myRecipe : myRecipes) {
                    String name = myRecipe.getRecipeName();
                    String description = myRecipe.getRecipeDescription();
                    String difficulty = myRecipe.getDifficulty().toString();
                    List<RecipeIngredients> ingredients = recipeIngredientsRepository.findIngredientsByRecipeId(myRecipe.getId());
                    for (RecipeIngredients ingredient : ingredients) {
                        String ingredientName = ingredient.getIngredient().getIngredientName();
                        Double ingredientQuantity = ingredient.getMeasurementQuantity();
                        String measurementType = ingredient.getMeasurementType();

                        Triplet<String, Double, String> ingredientInfo = new Triplet<>(ingredientName, ingredientQuantity, measurementType);
                        ingredientsNames.add(ingredientInfo);
                    }
                    Quartet<String, String, String, List<Triplet<String, Double, String>>> recipeInfo = new Quartet<>(name, description, difficulty, ingredientsNames);
                    myRecipesDetails.add(recipeInfo);
                }
            } else {
                throw new NotFoundException("You have no uploaded recipes");
            }

            return myRecipesDetails;
        }

        // need a method which returns recipe name, description,
        public List<Quintet<String, String, String, String, List<Triplet<String, Double, String>>>> getRecipeByName(String recipeName) {

            List<Recipe> recipes = getAllRecipes();
            List<Quintet<String, String, String, String, List<Triplet<String, Double, String>>>> requestedRecipes = new ArrayList<>();
            List<Triplet<String, Double, String>> ingredientsNames = new ArrayList<>();
            boolean requestedRecipeFound = false;

            for (Recipe recipe : recipes) {
                if (recipe.getRecipeName().contains(recipeName)) {
                    String name = recipe.getRecipeName();
                    String description = recipe.getRecipeDescription();
                    String recipeAuthor = recipe.getUser().getUserName();
                    String difficulty = recipe.getDifficulty().toString();
                    List<RecipeIngredients> ingredients = recipeIngredientsRepository.findIngredientsByRecipeId(recipe.getId());
                    for (RecipeIngredients ingredient : ingredients) {
                      String ingredientName =  ingredient.getIngredient().getIngredientName();
                      Double ingredientQuantity = ingredient.getMeasurementQuantity();
                      String measurementType = ingredient.getMeasurementType();

                      Triplet<String, Double, String> ingredientInfo = new Triplet<>(ingredientName, ingredientQuantity, measurementType);
                      ingredientsNames.add(ingredientInfo);
                    }

                    Quintet<String, String, String, String, List<Triplet<String, Double, String>>> recipeInfo = new Quintet<>(name, description, recipeAuthor, difficulty, ingredientsNames);
                    requestedRecipes.add(recipeInfo);
                    requestedRecipeFound = true;
                }
            }
            if (!requestedRecipeFound) {
                throw new NotFoundException("Sorry we could not find any recipes with this name");
            }

            return requestedRecipes;

        }

        @Transactional
        public void addRecipe(String recipeName,
                              String recipeDescription,
                              RecipeDifficulty difficulty, User user) {

            Recipe recipe = new Recipe();
            recipe.setRecipeName(recipeName);
            recipe.setRecipeDescription(recipeDescription);
            recipe.setDifficulty(difficulty);
            recipe.setUser(user);
            recipeRepository.save(recipe);
        }

        private Recipe findRecipeUsingName(String recipeName) {
            long recipeId =  recipeRepository.findRecipeIdByName(recipeName);
            return(recipeRepository.findById(recipeId).get());
        }


        @Transactional
        public void deleteRecipe(String recipeName, Long userId) {
            Recipe recipe = findRecipeUsingName(recipeName);
            if (Objects.equals(recipe.getUser().getId(), userId)) {
                recipeRepository.delete(recipe);
            } else {
                throw new NotAllowedToModify("You do not have permission to delete this recipe");
            }

        }

        @Transactional
        public void updateRecipe(String recipeName, String updatedRecipeDescription,
                                 RecipeDifficulty updatedRecipeDifficulty, Long userId) {
            Recipe recipe = findRecipeUsingName(recipeName);
            if (Objects.equals(recipe.getUser().getId(), userId)) {
                if(updatedRecipeDescription != null && updatedRecipeDifficulty == null) {
                    recipe.setRecipeDescription(updatedRecipeDescription);
                }
                if(updatedRecipeDifficulty != null && updatedRecipeDescription == null) {
                    recipe.setDifficulty(updatedRecipeDifficulty);
                }
                if(updatedRecipeDescription != null && updatedRecipeDifficulty != null) {
                    recipe.setRecipeDescription(updatedRecipeDescription);
                    recipe.setDifficulty(updatedRecipeDifficulty);
                }
                recipeRepository.save(recipe);
            } else {
                throw new NotAllowedToModify("You do not have permission to edit this recipe");
            }

        }
}