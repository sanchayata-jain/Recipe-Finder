//package com.RecipeFinderBackend.RecipeFinder.reciperequirements;
//
//import com.RecipeFinderBackend.RecipeFinder.exceptions.NotAllowedToModify;
//import com.RecipeFinderBackend.RecipeFinder.exceptions.NotFoundException;
//import com.RecipeFinderBackend.RecipeFinder.recipe.Recipe;
//import com.RecipeFinderBackend.RecipeFinder.recipe.RecipeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Service
//public class RecipeRequirementService {
//    @Autowired
//    private final RecipeRequirementRepository recipeRequirementRepository;
//    private final RecipeRepository recipeRepository;
//
//
//    // Constructor
//    public RecipeRequirementService(RecipeRequirementRepository recipeRequirementRepository,
//                                    RecipeRepository recipeRepository) {
//
//        this.recipeRequirementRepository = recipeRequirementRepository;
//        this.recipeRepository = recipeRepository;
//    }
//
//    // Methods
//
//    @Transactional
//    public void addRecipeRequirement(String recipeName, Long userId, Requirements requirement) {
//       long recipeId = recipeRepository.findRecipeIdByName(recipeName);
//       Optional<Recipe> recipe = recipeRepository.findById(recipeId);
//       if (recipe.isPresent()) {
//           Recipe realRecipe = recipeRepository.findById(recipeId).get();
//           if (Objects.equals(realRecipe.getUser().getId(), userId)) {
//               RecipeRequirement recipeRequirement = new RecipeRequirement();
//               recipeRequirement.setRecipe(realRecipe);
//               recipeRequirement.setRecipeRequirement(requirement);
//               System.out.println(recipeRequirement.getRecipeRequirement());
//               recipeRequirementRepository.save(recipeRequirement);
//           } else {
//               throw new NotAllowedToModify("You do not have permission to add any information about this recipe");
//           }
//       } else {
//           throw new NotFoundException("Sorry we can not find the recipe you are looking for");
//       }
//    }
//
//    @Transactional
//    public void deleteRecipeRequirement(String recipeName, Requirements requirement, Long userId) {
//        long recipeId = recipeRepository.findRecipeIdByName(recipeName);
//        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
//        if (recipe.isPresent()) {
//            Recipe realRecipe = recipeRepository.findById(recipeId).get();
//            if (realRecipe.getUser().getId() == userId) {
//                boolean requirementFound = false;
//                List<RecipeRequirement> recipeRequirements = recipeRequirementRepository.findRecipeRequirement(recipeId);
//                for (RecipeRequirement recipeRequirement : recipeRequirements) {
//                    if (recipeRequirement.getRecipeRequirement().name().equals(requirement)) {
//                        recipeRequirementRepository.delete(recipeRequirement);
//                        requirementFound = true;
//                        break;
//                    }
//                }
//
//                if (!requirementFound) {
//                    throw new NotFoundException("Sorry we can not find the recipe information you are looking for");
//                }
//
//            } else {
//                throw new NotAllowedToModify("Sorry you do not have permission to delete this information");
//            }
//
//        } else {
//            throw new NotFoundException("Sorry this recipe does not exist");
//        }
//    }
//
//
//}
