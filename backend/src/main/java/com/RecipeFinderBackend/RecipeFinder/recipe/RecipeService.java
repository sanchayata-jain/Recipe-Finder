package com.RecipeFinderBackend.RecipeFinder.recipe;

import com.RecipeFinderBackend.RecipeFinder.exceptions.NotAllowedToModify;
import com.RecipeFinderBackend.RecipeFinder.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


        public List<Recipe> getAllRecipes() {
            // this method will only return details stored in the recipes table,
            // not any of the ingredients which are needed to make the recipe
            return recipeRepository.findAll();
        }

        // need a method which returns recipe name, description,

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