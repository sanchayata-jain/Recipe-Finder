package com.RecipeFinderBackend.RecipeFinder.recipeingredients;

import com.RecipeFinderBackend.RecipeFinder.exceptions.UserNotLoggedIn;
import com.RecipeFinderBackend.RecipeFinder.users.UserService;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe-ingredients")
public class RecipeIngredientsController {
    @Autowired
    private final RecipeIngredientsService recipeIngredientsService;
    private final UserService userService;

    // Constructor
    public RecipeIngredientsController(RecipeIngredientsService recipeIngredientsService,
                                       UserService userService) {
        this.recipeIngredientsService = recipeIngredientsService;
        this.userService = userService;
    }

    //Methods

    @GetMapping
    public List<Quartet<String, String, Double, String>> getRecipeIngredients(@RequestParam String recipeName) {
        // Enter a recipe name and get its ingredients
        return recipeIngredientsService.getRecipeIngredients(recipeName);
    }

    @GetMapping("/get-recipe-names")
    public List<String> getRecipeNames(@RequestParam String ingredientName1,
                                       @RequestParam(required = false) String ingredientName2,
                                       @RequestParam(required = false) String ingredientName3) {
        // enter three ingredients to get recipe names containing ingredient(s)

        return recipeIngredientsService.getRecipeNamesUsingIngredientsEntered(ingredientName1,
                                                                              ingredientName2,
                                                                              ingredientName3);
    }

    @GetMapping("/get-recipes-by-ingredient")
    public List<Quintet<String, String, String, String, List<Triplet<String, Double, String>>>> getRecipesByIngredient(@RequestParam String ingredientName1,
                                                                                                                       @RequestParam(required = false) String ingredientName2,
                                                                                                                       @RequestParam(required = false) String ingredientName3) {
        ingredientName1.replace("%20", " ");
        return recipeIngredientsService.getRecipesByIngredient(ingredientName1);
    }

//    @GetMapping("/get-recipes-by-ingredient")
//    public List<RecipeDTO>getRecipesByIngredient(@RequestParam String ingredientName1) {
//        ingredientName1.replace("%20", " ");
//        return recipeIngredientsService.getRecipesByIngredient((ingredientName1));
//    }


    @PostMapping("/add")
    public void addRecipeIngredients(@RequestParam String ingredientName,
                                     @RequestParam String recipeName,
                                     @RequestParam String measurementType,
                                     @RequestParam double measurementQuantity) {

        if (userService.isUserLoggedIn()) {
            // add ingredients, their measurements and measurement types for a particular recipe
            ingredientName.replace("%20", " ");
            recipeName.replace("%20", " ");
            measurementType.replace("%20", " ");
            recipeIngredientsService.addRecipeIngredients(ingredientName, recipeName,
                                                          measurementType, measurementQuantity,
                                                          userService.getLoggedInUser().getId());
        } else {
            throw new UserNotLoggedIn("Please log in to add ingredients for your recipe");
        }
    }

    @DeleteMapping("/delete-recipe-ingredient")
    public void deleteRecipeIngredient(@RequestParam String recipeName,
                                       @RequestParam String ingredientName) {
        if (userService.isUserLoggedIn()) {
            ingredientName.replace("%20", " ");
            recipeName.replace("%20", " ");

            recipeIngredientsService.deleteRecipeIngredient(recipeName, ingredientName, userService.getLoggedInUser().getId());
        } else {
            throw new UserNotLoggedIn("Please log in to delete ingredients for your recipe");
        }
    }

    @PutMapping("/update-recipe-ingredient")
    public void updateRecipeIngredient(@RequestParam String recipeName,
                                       @RequestParam String ingredientName,
                                       @RequestParam(required = false) String updatedMeasurementType,
                                       @RequestParam(required = false) Double updatedMeasurementQuantity) {

        if (userService.isUserLoggedIn()) {
            ingredientName.replace("%20", " ");
            recipeName.replace("%20", " ");
            if (updatedMeasurementType != null) {
                updatedMeasurementType.replace("%20", " ");
            }

            recipeIngredientsService.updateRecipeIngredient(recipeName,
                                                            ingredientName,
                                                            updatedMeasurementType,
                                                            updatedMeasurementQuantity,
                                                            userService.getLoggedInUser().getId());
        } else {
            throw new UserNotLoggedIn("Please log in to edit ingredients for your recipe");
        }
    }
}
