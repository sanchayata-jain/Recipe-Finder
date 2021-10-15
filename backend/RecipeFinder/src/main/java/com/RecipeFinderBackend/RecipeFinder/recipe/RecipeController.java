package com.RecipeFinderBackend.RecipeFinder.recipe;

import com.RecipeFinderBackend.RecipeFinder.exceptions.UserNotLoggedIn;
import com.RecipeFinderBackend.RecipeFinder.recipeingredients.RecipeIngredients;
import com.RecipeFinderBackend.RecipeFinder.users.UserService;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private final RecipeService recipeService;
    private final UserService userService;

    // Constructor
    public RecipeController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    // Methods

    @GetMapping("/all-recipes")
    public List<Recipe> getRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/get-recipes")
    public List<Quintet<String, String, String, String, List<Triplet<String, Double, String>>>> getRecipesByName(@RequestParam String recipeName) {
        recipeName.replace("%20", " ");
        return recipeService.getRecipeByName(recipeName);
    }


    @GetMapping("get-my-recipes")
    public List<Quartet<String, String, String, List<Triplet<String, Double, String>>>> getMyRecipes() {
        if (userService.isUserLoggedIn()) {
            return recipeService.getMyRecipes(userService.getLoggedInUser().getId());
        } else {
            throw new UserNotLoggedIn("Please log in to view your recipes");
        }

    }


    @PostMapping("/add-recipe")
    @ResponseBody
    public void addRecipe(@RequestParam String recipeName,
                          @RequestParam String recipeDescription,
                          @RequestParam("difficulty") RecipeDifficulty difficulty) {
        if (userService.isUserLoggedIn()) {
            recipeName.replace("%20", " ");
            recipeDescription.replace("%20", " ");
            recipeDescription.replace("%0A", " ");
            recipeService.addRecipe(recipeName, recipeDescription,
                                    difficulty, userService.getLoggedInUser());

        } else {
            throw new UserNotLoggedIn("You need to log in to add a recipe");
        }
    }

    @DeleteMapping("/delete-recipe")
    public void deleteRecipe(@RequestParam String recipeName) {
        if (userService.isUserLoggedIn()) {
            recipeName.replace("%20", " ");
            recipeService.deleteRecipe(recipeName, userService.getLoggedInUser().getId());
        } else {
            throw new UserNotLoggedIn("You need to log in to delete a recipe");
        }

    }

    @PutMapping("/update-recipe")
    public void updateRecipe(@RequestParam String recipeName,
                             @RequestParam(required = false) String updatedRecipeDescription,
                             @RequestParam(required = false) RecipeDifficulty updatedRecipeDifficulty) {
        if (userService.isUserLoggedIn()) {
            if (updatedRecipeDescription != null) {
                updatedRecipeDescription.replace("%20", " ");
                updatedRecipeDescription.replace("%0A", " ");
            }

            recipeService.updateRecipe(recipeName, updatedRecipeDescription,
                                       updatedRecipeDifficulty, userService.getLoggedInUser().getId());
        } else {
            throw new UserNotLoggedIn("Please log in to edit one of your recipes");
        }

    }
}
