package com.RecipeFinderBackend.RecipeFinder.ingredients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository
        extends JpaRepository<Ingredient, Long> {

    @Query(value = "SELECT id FROM ingredients WHERE ingredient_name = :ingredientName",
            nativeQuery = true)
    int findIngredientIdByName(@Param("ingredientName") String ingredientName);

    @Modifying
    @Query(value = "DELETE FROM ingredients WHERE ingredient_category_id = :ingredientCategoryId",
            nativeQuery = true)
    void deleteIngredientByCategoryId(@Param("ingredientCategoryId") int ingredientCategoryId);
}
