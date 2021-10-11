//package com.RecipeFinderBackend.RecipeFinder.reciperequirements;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@Repository
//public interface RecipeRequirementRepository extends JpaRepository<RecipeRequirement, Long> {
//    @Query(value = "SELECT * FROM recipe_requirements WHERE recipe_id= : recipeId", nativeQuery = true)
//    List<RecipeRequirement> findRecipeRequirement(@Param("recipeId") long recipeId);
//}
