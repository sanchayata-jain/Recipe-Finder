package com.RecipeFinderBackend.RecipeFinder.users;

import com.RecipeFinderBackend.RecipeFinder.ingredients.Ingredient;
import com.RecipeFinderBackend.RecipeFinder.recipe.Recipe;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;



@Entity(name = "User")
@Table(name = "users")

public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "user_id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "user_name",
            nullable = false,
            unique = true
    )
    private String userName;

    @Column(
            name = "user_email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            name = "user_password",
            nullable = false,
            columnDefinition = "CHAR(60)"
    )
    private String password;

    @Column(
            name = "logged_in",
            nullable = false
    )
    private boolean loggedIn;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes;

    // Constructors
    public User() {
    }

    public User(String name, String email, String password, String loggedIn) {
        this.userName = name;
        this.email = email;
        this.password = password;
        this.loggedIn = false;
    }

    // Methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getLoggedIn() { return loggedIn; }

    public void setLoggedIn(boolean loggedIn) { this.loggedIn = loggedIn; }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        com.RecipeFinderBackend.RecipeFinder.user.User user = (com.RecipeFinderBackend.RecipeFinder.user.User) o;
//        return id == user.id && Objects.equals(userName, user.userName) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, userName, email, password);
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", userName='" + userName + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}

