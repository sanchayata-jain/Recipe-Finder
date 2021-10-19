package com.RecipeFinderBackend.RecipeFinder.ingredientcategories;

import com.RecipeFinderBackend.RecipeFinder.exceptions.UserNotLoggedIn;
import com.RecipeFinderBackend.RecipeFinder.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ingredient-categories")
public class IngredientCategoryController {

    private final IngredientCategoryService ingredientCategoryService;
    private final UserService userService;

    // Constructor
    @Autowired
    public IngredientCategoryController(IngredientCategoryService ingredientCategoryService,
                                        UserService userService) {
        this.ingredientCategoryService = ingredientCategoryService;
        this.userService = userService;
    }

    // Methods

    @GetMapping("/all-ingredient-categories")
    public List<IngredientCategory> getIngredientCategories() {
        return ingredientCategoryService.getIngredientCategories();
    }

    @PostMapping("/add-ingredient-category")
    @ResponseBody
    public void addIngredientCategory(@RequestBody IngredientCategory ingredientCategory) {
        if (userService.isUserLoggedIn()) {
            ingredientCategoryService.addIngredientCategory(ingredientCategory);
        } else {
            throw new UserNotLoggedIn("You need to be logged in to add a new ingredient category");
        }
    }

    @DeleteMapping("/delete-ingredient-category")
    public void deleteIngredientCategory(@RequestParam String ingredientCategoryName) {
        if (userService.isUserLoggedIn()) {
            ingredientCategoryName.replace("%20", " ");
            ingredientCategoryService.deleteIngredientCategory(ingredientCategoryName);
        } else {
            throw new UserNotLoggedIn("You need to be logged in to delete an ingredient category");
        }
    }

    @PutMapping("/update-ingredient-category")
    public void updateIngredientCategory(@RequestParam String ingredientCategoryName,
                                         @RequestParam(required = false) String updatedIngredientCategoryName) {
        if (userService.isUserLoggedIn()) {
            ingredientCategoryName.replace("%20", " ");
            updatedIngredientCategoryName.replace("%20", " ");
            ingredientCategoryService.updateIngredientCategory(ingredientCategoryName,
                                                               updatedIngredientCategoryName);
        } else {
            throw new UserNotLoggedIn("You need to be logged in to edit an ingredient category");
        }
    }
}
