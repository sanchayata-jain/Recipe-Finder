package com.RecipeFinderBackend.RecipeFinder.recipe;

import com.RecipeFinderBackend.RecipeFinder.recipeingredients.RecipeIngredients;
import com.RecipeFinderBackend.RecipeFinder.users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Table(name= "recipes")
@Entity(name= "Recipe")

public class Recipe {
    @Id
    @SequenceGenerator(
            name= "recipe_sequence",
            sequenceName = "recipe_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recipe_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private Long id;


    @Column(
            name = "recipe_name",
            unique = true
    )
    private String recipeName;


    @Column(
            name= "recipe_description",
            nullable = false,
            columnDefinition = "VARCHAR(10485760)"
    )
    private String recipeDescription;

    @Enumerated(EnumType.STRING)
    @Column(
           name ="difficulty"
    )
    private RecipeDifficulty difficulty;

    @Column(
           name = "average_rating"
    )
    double averageRating;


    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "recipe"
    )
    private List<RecipeIngredients> recipeIngredients = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // Constructors
    public Recipe() {}

    public Recipe(String recipeName, String recipeDescription, RecipeDifficulty difficulty, double averageRating, User user ) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.difficulty = difficulty;
        this.averageRating = averageRating;
        this.user = user;
    }

    // Methods
    public void setUser(User user) { this.user = user; }

    public User getUser() { return user; }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setDifficulty(RecipeDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public RecipeDifficulty getDifficulty() {
        return difficulty;
    }

    public double getAverageRating() {
        return averageRating;
    }


//    @Override
//    public String toString() {
//        return "Recipe{" +
//                "id=" + id +
//                ", recipeName='" + recipeName + '\'' +
//                ", recipeDescription='" + recipeDescription + '\'' +
//                ", difficulty='" + difficulty + '\'' +
//                ", averageRating=" + averageRating +
//                '}';
//    }


}
