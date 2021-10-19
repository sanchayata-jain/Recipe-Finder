package com.RecipeFinderBackend.RecipeFinder.ingredientcategories;

import com.RecipeFinderBackend.RecipeFinder.ingredients.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory, Integer> {

    @Query(value = "SELECT ingredient_category_id FROM ingredient_categories WHERE ingredient_category_name = :ingredientCategoryName",
    nativeQuery = true)
    int findIngredientCategoryIdByName(@Param("ingredientCategoryName") String ingredientCategoryName);

}
