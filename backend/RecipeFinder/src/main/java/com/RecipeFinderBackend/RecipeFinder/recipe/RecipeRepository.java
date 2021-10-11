package com.RecipeFinderBackend.RecipeFinder.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "SELECT id FROM recipes WHERE recipe_name = :recipeName",
            nativeQuery = true)
    int findRecipeIdByName(@Param("recipeName") String recipeName);

}
