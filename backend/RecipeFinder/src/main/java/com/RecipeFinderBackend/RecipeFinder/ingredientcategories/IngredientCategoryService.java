package com.RecipeFinderBackend.RecipeFinder.ingredientcategories;

import com.RecipeFinderBackend.RecipeFinder.ingredients.IngredientsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IngredientCategoryService {

    private final IngredientCategoryRepository ingredientCategoryRepository;
    private final IngredientsRepository ingredientsRepository;

    // Constructor
    public IngredientCategoryService(IngredientCategoryRepository ingredientCategoryRepository,
                                     IngredientsRepository ingredientsRepository) {
        this.ingredientCategoryRepository = ingredientCategoryRepository;
        this.ingredientsRepository = ingredientsRepository;
    }

    // Methods

    public List<IngredientCategory> getIngredientCategories() {

        return ingredientCategoryRepository.findAll();
    }

    @Transactional
    public void addIngredientCategory(IngredientCategory ingredientCategory) {
        ingredientCategoryRepository.save(ingredientCategory);
    }

    @Transactional
    public void deleteIngredientCategory(String ingredientCategoryName) {
        int ingredientCategoryId = ingredientCategoryRepository.findIngredientCategoryIdByName(ingredientCategoryName);
        IngredientCategory ingredientCategory = ingredientCategoryRepository.findById(ingredientCategoryId).get();
        ingredientsRepository.deleteIngredientByCategoryId(ingredientCategory.getIngredientCategoryId());
        ingredientCategoryRepository.delete(ingredientCategory);
    }

    @Transactional
    public void updateIngredientCategory(String ingredientCategoryName,
                                         String updatedIngredientCategoryName) {

        if (updatedIngredientCategoryName != null) {
            int ingredientCategoryId = ingredientCategoryRepository.findIngredientCategoryIdByName(ingredientCategoryName);
            IngredientCategory ingredientCategory = ingredientCategoryRepository.findById(ingredientCategoryId).get();
            ingredientCategory.setIngredientCategoryName(updatedIngredientCategoryName);
            ingredientCategoryRepository.save(ingredientCategory);
        } 

    }
}
