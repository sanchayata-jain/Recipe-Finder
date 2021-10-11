package com.RecipeFinderBackend.RecipeFinder.reciperequirements;

import com.RecipeFinderBackend.RecipeFinder.exceptions.UserNotLoggedIn;
import com.RecipeFinderBackend.RecipeFinder.recipe.RecipeDifficulty;
import com.RecipeFinderBackend.RecipeFinder.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("recipe-requirements")
public class RecipeRequirementController {
    @Autowired
    private final RecipeRequirementService recipeRequirementService;
    private final UserService userService;
    // Constructor
    public RecipeRequirementController(RecipeRequirementService recipeRequirementService,
                                       UserService userService) {
        this.recipeRequirementService = recipeRequirementService;
        this.userService = userService;
    }

    // Methods

    @PostMapping("/add-recipe-requirement")
    public void addRecipeRequirement(@RequestParam String recipeName,
                                     @RequestParam("difficulty") Requirements requirement) {
        if (userService.isUserLoggedIn()) {
            recipeRequirementService.addRecipeRequirement(recipeName,
                                                          userService.getLoggedInUser().getId(),
                                                          requirement);

        } else {
            throw new UserNotLoggedIn("Please log in to your account");
        }
    }
}
