package com.RecipeFinderBackend.RecipeFinder.recipeingredients;

import com.RecipeFinderBackend.RecipeFinder.exceptions.NotAllowedToModify;
import com.RecipeFinderBackend.RecipeFinder.exceptions.NotFoundException;
import com.RecipeFinderBackend.RecipeFinder.ingredients.Ingredient;
import com.RecipeFinderBackend.RecipeFinder.ingredients.IngredientsRepository;
import com.RecipeFinderBackend.RecipeFinder.recipe.Recipe;
import com.RecipeFinderBackend.RecipeFinder.recipe.RecipeRepository;
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
public class RecipeIngredientsService {

    @Autowired
    private final RecipeIngredientsRepository recipeIngredientsRepository;
    private final IngredientsRepository ingredientsRepository;
    private final RecipeRepository recipeRepository;



    // Constructor
    public RecipeIngredientsService(RecipeIngredientsRepository recipeIngredientsRepository,
                                    IngredientsRepository ingredientsRepository,
                                    RecipeRepository recipeRepository) {

        this.recipeIngredientsRepository = recipeIngredientsRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.recipeRepository = recipeRepository;

    }

     //Methods

    public List<Quartet<String, String, Double, String>> getRecipeIngredients(String recipeName) {
       long recipeId =  recipeRepository.findRecipeIdByName(recipeName);
       List<RecipeIngredients> recipeIngredientsList = recipeIngredientsRepository.findIngredientsByRecipeId(recipeId);

       List<Quartet<String, String, Double, String>> recipeDetails = new ArrayList<>();

       for (RecipeIngredients recipeIngredient : recipeIngredientsList) {
           String foundRecipeName = recipeIngredient.getRecipe().getRecipeName();
           String ingredientName = recipeIngredient.getIngredient().getIngredientName();
           double measurementQuantity = recipeIngredient.getMeasurementQuantity();
           String measurementType = recipeIngredient.getMeasurementType();

           Quartet<String, String, Double, String> recipeInfo = new Quartet<>(foundRecipeName, ingredientName, measurementQuantity, measurementType);
           recipeDetails.add(recipeInfo);
       }

       return recipeDetails;
    }


    private boolean contains(String recipeName, List<String> recipeIngredientsList) {
        for (String RecipeNameStored : recipeIngredientsList) {
            if (RecipeNameStored.equals(recipeName)) {
                return true;
            }
        }
        return false;
    }




//    public List<RecipeDTO> getRecipesByIngredient(String ingredientName) {
//        long ingredientId = ingredientsRepository.findIngredientIdByName(ingredientName);
//        List<Recipe> recipes = new ArrayList<>();
//        List<RecipeDTO> recipesInfo = new ArrayList<>();
//        List<RecipeIngredients> recipeIngredients =recipeIngredientsRepository.findRecipeIngredientsByIngredientId(ingredientId);
//
//        for (RecipeIngredients recipeIngredient : recipeIngredients) {
//            recipes.add(recipeIngredient.getRecipe());
//        }
//
////        List<Quintet<String, String, String, String, List<Triplet<String, Double, String>>>> requestedRecipes = new ArrayList<>();
////        List<Triplet<String, Double, String>> ingredientsNames = new ArrayList<>();
//        boolean requestedRecipeFound = false;
//
//        for (Recipe recipe : recipes) {
//            if (recipe.getRecipeDescription().contains(ingredientName)) {
//                String name = recipe.getRecipeName();
//                String description = recipe.getRecipeDescription();
//                String recipeAuthor = recipe.getUser().getUserName();
//                String difficulty = recipe.getDifficulty().toString();
//                List<RecipeIngredients> ingredients = recipeIngredientsRepository.findIngredientsByRecipeId(recipe.getId());
////                for (RecipeIngredients ingredient : ingredients) {
////                    String nameOfIngredient =  ingredient.getIngredient().getIngredientName();
////                    Double ingredientQuantity = ingredient.getMeasurementQuantity();
////                    String measurementType = ingredient.getMeasurementType();
////                    Triplet<String, Double, String> ingredientInfo = new Triplet<>(nameOfIngredient, ingredientQuantity, measurementType);
////                    ingredientsNames.add(ingredientInfo);
////                }
//
////                Quintet<String, String, String, String, List<Triplet<String, Double, String>>> recipeInfo = new Quintet<>(name, description, recipeAuthor, difficulty, ingredientsNames);
////                requestedRecipes.add(recipeInfo);
//                RecipeDTO recipeDTO = new RecipeDTO();
//                recipeDTO.setName(name);
//                recipeDTO.setRecipeDescription(description);
//                recipeDTO.setRecipeAuthor(recipeAuthor);
//                recipeDTO.setDifficulty(difficulty);
//
//                recipesInfo.add(recipeDTO);
//
//                requestedRecipeFound = true;
//            }
//        }
//        if (!requestedRecipeFound) {
//            throw new NotFoundException("Sorry we could not find any recipes containing this ingredient");
//        }
//        return recipesInfo;
//    }



    //need a method which returns recipe name, description,
    public List<Quintet<String, String, String, String, List<Triplet<String, Double, String>>>> getRecipesByIngredient(String ingredientName) {
       long ingredientId = ingredientsRepository.findIngredientIdByName(ingredientName);
       List<Recipe> recipes = new ArrayList<>();

       List<RecipeIngredients> recipeIngredients =recipeIngredientsRepository.findRecipeIngredientsByIngredientId(ingredientId);

       for (RecipeIngredients recipeIngredient : recipeIngredients) {
           recipes.add(recipeIngredient.getRecipe());
       }

        List<Quintet<String, String, String, String, List<Triplet<String, Double, String>>>> requestedRecipes = new ArrayList<>();
        List<Triplet<String, Double, String>> ingredientsNames = new ArrayList<>();
        boolean requestedRecipeFound = false;

        for (Recipe recipe : recipes) {
            if (recipe.getRecipeName().contains(ingredientName)) {
                String name = recipe.getRecipeName();
                String description = recipe.getRecipeDescription();
                String recipeAuthor = recipe.getUser().getUserName();
                String difficulty = recipe.getDifficulty().toString();
                List<RecipeIngredients> ingredients = recipeIngredientsRepository.findIngredientsByRecipeId(recipe.getId());
                for (RecipeIngredients ingredient : ingredients) {
                    String nameOfIngredient =  ingredient.getIngredient().getIngredientName();
                    Double ingredientQuantity = ingredient.getMeasurementQuantity();
                    String measurementType = ingredient.getMeasurementType();
                    Triplet<String, Double, String> ingredientInfo = new Triplet<>(nameOfIngredient, ingredientQuantity, measurementType);
                    ingredientsNames.add(ingredientInfo);
                }

                Quintet<String, String, String, String, List<Triplet<String, Double, String>>> recipeInfo = new Quintet<>(name, description, recipeAuthor, difficulty, ingredientsNames);
                requestedRecipes.add(recipeInfo);
                requestedRecipeFound = true;
            }
        }
        if (!requestedRecipeFound) {
            throw new NotFoundException("Sorry we could not find any recipes containing this ingredient");
        }
        return requestedRecipes;
    }


    public List<String> getRecipeNamesUsingIngredientsEntered(String ingredient1, String ingredient2, String ingredient3) {
        List<String> recipeIngredientsList = new ArrayList<>();
        long ingredientId1 = ingredientsRepository.findIngredientIdByName(ingredient1);
        List<RecipeIngredients> recipeIngredientsList1 = recipeIngredientsRepository.findRecipeIngredientsByIngredientId(ingredientId1);
        for (RecipeIngredients recipeIngredients : recipeIngredientsList1) {
            recipeIngredientsList.add(recipeIngredients.getRecipe().getRecipeName());
        }

        if (ingredient2 != null && ingredient3 != null) {
            long ingredientId2 = ingredientsRepository.findIngredientIdByName(ingredient2);
            long ingredientId3 = ingredientsRepository.findIngredientIdByName(ingredient3);
            List<RecipeIngredients> recipeIngredientsList2 = recipeIngredientsRepository.findRecipeIngredientsByIngredientId(ingredientId2);
            List<RecipeIngredients> recipeIngredientsList3 = recipeIngredientsRepository.findRecipeIngredientsByIngredientId(ingredientId3);

            for (RecipeIngredients recipeIngredients : recipeIngredientsList2) {
               boolean recipeAlreadySelected = contains(recipeIngredients.getRecipe().getRecipeName(),
                                                        recipeIngredientsList);
               if (!recipeAlreadySelected) {
                   recipeIngredientsList.add(recipeIngredients.getRecipe().getRecipeName());
               }
            }
            for (RecipeIngredients recipeIngredients : recipeIngredientsList3) {
                boolean recipeAlreadySelected = contains(recipeIngredients.getRecipe().getRecipeName(),
                                                         recipeIngredientsList);
                if (!recipeAlreadySelected) {
                    recipeIngredientsList.add(recipeIngredients.getRecipe().getRecipeName());
                }
            }
            return recipeIngredientsList;


        } else if (ingredient2 != null && ingredient3 == null) {
            long ingredientId2 = ingredientsRepository.findIngredientIdByName(ingredient2);
            List<RecipeIngredients> recipeIngredientsList2 = recipeIngredientsRepository.findRecipeIngredientsByIngredientId(ingredientId2);
            for (RecipeIngredients recipeIngredients : recipeIngredientsList2) {
                boolean recipeAlreadySelected = contains(recipeIngredients.getRecipe().getRecipeName(),
                                                         recipeIngredientsList);
                if (!recipeAlreadySelected) {
                    recipeIngredientsList.add(recipeIngredients.getRecipe().getRecipeName());
                }
            }
            return recipeIngredientsList;

        } else if (ingredient2 == null && ingredient3 != null) {
            long ingredientId3 = ingredientsRepository.findIngredientIdByName(ingredient3);
            List<RecipeIngredients> recipeIngredientsList3 = recipeIngredientsRepository.findRecipeIngredientsByIngredientId(ingredientId3);
            for (RecipeIngredients recipeIngredients : recipeIngredientsList3) {
                boolean recipeAlreadySelected = contains(recipeIngredients.getRecipe().getRecipeName(),
                                                         recipeIngredientsList);
                if (!recipeAlreadySelected) {
                    recipeIngredientsList.add(recipeIngredients.getRecipe().getRecipeName());
                }
            }

            return recipeIngredientsList;
        }

        return recipeIngredientsList;

    }

    @Transactional
    public void addRecipeIngredients(String ingredientName, String recipeName,
                                     String measurementType, double measurementQuantity,
                                     Long userId) {

        long ingredientId = ingredientsRepository.findIngredientIdByName(ingredientName);
        long recipeId = recipeRepository.findRecipeIdByName(recipeName);

        Ingredient ingredient =  ingredientsRepository.findById(ingredientId).get();
        Recipe recipe = recipeRepository.findById(recipeId).get();
        if (Objects.equals(userId, recipe.getUser().getId())) {
            RecipeIngredients recipeIngredients = new RecipeIngredients();
            recipeIngredients.setIngredient(ingredient);
            recipeIngredients.setRecipe(recipe);
            recipeIngredients.setMeasurementQuantity(measurementQuantity);
            recipeIngredients.setMeasurementType(measurementType);

            recipeIngredientsRepository.save(recipeIngredients);
        } else {
            throw new NotAllowedToModify("Sorry you do not have permission to add ingredients to this recipe");
        }


    }

    private RecipeIngredients getRecipeIngredient(String recipeName, String ingredientName) {
        long ingredientId = ingredientsRepository.findIngredientIdByName(ingredientName);
        long recipeId = recipeRepository.findRecipeIdByName(recipeName);

        return recipeIngredientsRepository.findRecipeIngredient(recipeId, ingredientId);
    }

    @Transactional
    public void deleteRecipeIngredient(String recipeName, String ingredientName, Long userId) {
       RecipeIngredients recipeIngredients = getRecipeIngredient(recipeName, ingredientName);
        if (Objects.equals(recipeIngredients.getRecipe().getUser().getId(), userId)) {
            recipeIngredientsRepository.delete(recipeIngredients);
        } else {
            throw new NotAllowedToModify("Sorry you do not have permission to delete an ingredient for this recipe");
        }
    }

    @Transactional
    public void updateRecipeIngredient(String recipeName, String ingredientName,
                                       String updatedMeasurementType, Double updatedMeasurementQuantity,
                                       Long userId) {

        if (updatedMeasurementType != null || updatedMeasurementQuantity != null) {
           RecipeIngredients recipeIngredients = getRecipeIngredient(recipeName, ingredientName);
           if (recipeIngredients.getRecipe().getUser().getId() == userId) {
               if (updatedMeasurementType != null) {
                   recipeIngredients.setMeasurementType(updatedMeasurementType);
               }
               if (updatedMeasurementQuantity != null) {
                   recipeIngredients.setMeasurementQuantity(updatedMeasurementQuantity);
               }

               recipeIngredientsRepository.save(recipeIngredients);
           } else {
               throw new NotAllowedToModify("Sorry you do not have permission to edit the ingredients for this recipe");
           }

       }

    }


}
