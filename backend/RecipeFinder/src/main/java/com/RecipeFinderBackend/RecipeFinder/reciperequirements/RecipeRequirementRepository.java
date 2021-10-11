package com.RecipeFinderBackend.RecipeFinder.reciperequirements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRequirementRepository extends JpaRepository<RecipeRequirement, Long> {

}
