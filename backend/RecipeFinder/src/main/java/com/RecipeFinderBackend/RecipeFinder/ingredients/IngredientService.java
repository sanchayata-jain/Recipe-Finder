package com.RecipeFinderBackend.RecipeFinder.ingredients;

import com.RecipeFinderBackend.RecipeFinder.ingredientcategories.IngredientCategoryRepository;
import com.RecipeFinderBackend.RecipeFinder.ingredientcategories.IngredientCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IngredientService {

    private final IngredientsRepository ingredientsRepository;
    private final IngredientCategoryRepository ingredientCategoryRepository;


    @Autowired
    public IngredientService(IngredientsRepository ingredientsRepository,
                             IngredientCategoryRepository ingredientCategoryRepository) {

        this.ingredientsRepository = ingredientsRepository;
        this.ingredientCategoryRepository = ingredientCategoryRepository;
    }


    public List<Ingredient> getAllIngredients() {

        return ingredientsRepository.findAll();
    }


    private Ingredient findIngredientByName(String ingredientName) {
        long ingredientId = ingredientsRepository.findIngredientIdByName(ingredientName);
        return(ingredientsRepository.findById(ingredientId).get());
    }

    private IngredientCategory findIngredientCategoryByName(String ingredientCategoryName) {
        int ingredientCategoryId = ingredientCategoryRepository.findIngredientCategoryIdByName(ingredientCategoryName);
        return(ingredientCategoryRepository.findById(ingredientCategoryId).get());
    }


    @Transactional
    public void addIngredient(String ingredientCategoryName, String ingredientName ) {
        IngredientCategory ingredientCategory = findIngredientCategoryByName(ingredientCategoryName);
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(ingredientName);
        ingredient.setIngredientCategory(ingredientCategory);
        ingredientsRepository.save(ingredient);
    }

    @Transactional
    public void deleteIngredient (String ingredientName) {
        Ingredient ingredient = findIngredientByName(ingredientName);
        ingredientsRepository.delete(ingredient);
    }

    @Transactional
    public void updateIngredient (String ingredientName,
                                  String updatedIngredientName) {

        Ingredient ingredient = findIngredientByName(ingredientName);

        if (updatedIngredientName != null) {
            ingredient.setIngredientName(updatedIngredientName);
            ingredientsRepository.save(ingredient);
        }

//        if (updatedIngredientCategoryName != null) {
//            IngredientCategory ingredientCategory = findIngredientCategoryByName(updatedIngredientCategoryName);
//            ingredient.setIngredientCategory(ingredientCategory);
//            ingredientsRepository.save(ingredient);
//        }

    }

}
