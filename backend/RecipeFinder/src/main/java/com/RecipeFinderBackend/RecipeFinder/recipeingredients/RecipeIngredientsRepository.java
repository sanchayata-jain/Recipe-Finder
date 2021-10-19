package com.RecipeFinderBackend.RecipeFinder.recipeingredients;

import com.RecipeFinderBackend.RecipeFinder.ingredients.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients, Long> {
    @Query(value = "SELECT * FROM recipe_ingredients WHERE recipe_id = :recipeId",
            nativeQuery = true)
    List<RecipeIngredients> findIngredientsByRecipeId(@Param("recipeId") long recipeId);


    @Query(value = "SELECT * FROM recipe_ingredients WHERE ingredient_id = :ingredientId",
            nativeQuery = true)
    List<RecipeIngredients> findRecipeIngredientsByIngredientId(@Param("ingredientId") long ingredientId);

    @Query(value = "SELECT * FROM recipe_ingredients WHERE recipe_id = :recipeId AND ingredient_id = :ingredientId",
    nativeQuery = true)
    RecipeIngredients findRecipeIngredient(@Param("recipeId") long recipeId,
                                           @Param("ingredientId") long ingredientId);

    @Query(value = "SELECT * FROM recipe_ingredients where ingredient_name = :ingredientName",
            nativeQuery = true)
    List<RecipeIngredients> findRecipeIngredientByName(@Param("ingredientName") String ingredientName);
}
