package com.RecipeFinderBackend.RecipeFinder.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT p FROM User p WHERE p.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);


    @Query("SELECT p FROM User p WHERE p.email = :email AND p.password = :password")
    User findUser(@Param("email") String email,
                                              @Param("password") String password);




//    @Modifying
//    @Query("DELETE FROM User s WHERE s.id = ?1")
//    int deleteUserById(int id);
}
