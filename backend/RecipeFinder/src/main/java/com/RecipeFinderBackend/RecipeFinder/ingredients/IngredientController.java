package com.RecipeFinderBackend.RecipeFinder.ingredients;

import com.RecipeFinderBackend.RecipeFinder.exceptions.UserNotLoggedIn;
import com.RecipeFinderBackend.RecipeFinder.users.User;
import com.RecipeFinderBackend.RecipeFinder.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ingredients")
public class IngredientController {

    private final IngredientService ingredientService;
    private final UserService userService;

    // Constructor
    @Autowired
    public IngredientController(IngredientService ingredientService, UserService userService) {
        this.ingredientService = ingredientService;
        this.userService = userService;
    }

    // Methods
    @GetMapping("/all-ingredients")
    public List<Ingredient> getAllIngredients() {

        return (ingredientService.getAllIngredients());
    }

    @PostMapping("/add-ingredient/{ingredientCategoryName}/{ingredientName}")
    public void addIngredient(@PathVariable String ingredientCategoryName,
                              @PathVariable String ingredientName) {
        if (userService.isUserLoggedIn()) {
            ingredientName.replace("%20", " ");
            ingredientService.addIngredient(ingredientCategoryName, ingredientName);
        } else {
            throw new UserNotLoggedIn("Please log in to add an ingredient");
        }
    }

    @DeleteMapping("/delete-ingredient")
    public void deleteIngredient(@RequestParam String ingredientName) {
        if (userService.isUserLoggedIn()) {
            ingredientName.replace("%20", " ");
            ingredientService.deleteIngredient(ingredientName);
        } else {
            throw new UserNotLoggedIn("Please log in to delete an ingredient");
        }
    }

    @PutMapping("/update-ingredient")
    public void updateIngredient(@RequestParam String ingredientName,
                                 @RequestParam(required = false) String updatedIngredientName) {

        if (userService.isUserLoggedIn()) {
            ingredientName.replace("%20", " ");
            updatedIngredientName.replace("%20", " ");
//        updatedIngredientCategoryName.replace("%20", " ");
            ingredientService.updateIngredient(ingredientName, updatedIngredientName);
        } else {
            throw new UserNotLoggedIn("Please log in to edit an ingredient");
        }
    }

}
