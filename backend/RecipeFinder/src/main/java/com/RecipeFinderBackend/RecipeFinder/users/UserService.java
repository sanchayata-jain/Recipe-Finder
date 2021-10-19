package com.RecipeFinderBackend.RecipeFinder.users;

import com.RecipeFinderBackend.RecipeFinder.exceptions.AlreadyExistsException;
import com.RecipeFinderBackend.RecipeFinder.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private User loggedInUser;

    // Constructor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.loggedInUser = null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    @Transactional
    public void userLogIn(String email, String password) {
        User user = findUserAccount(email, password);
        user.setLoggedIn(true);
        this.loggedInUser = user;
    }


    @Transactional
    public void userLogsOut() {
        Long loggedInUserId = this.loggedInUser.getId();
        User user = userRepository.findById(loggedInUserId).get();
        user.setLoggedIn(false);
        this.loggedInUser = null;
    }

    public boolean isUserLoggedIn() {
        if (this.loggedInUser != null) {
            return true;
        }
        return false;
    }


    @Transactional
    public void addNewUser(String userName, String email, String password) {
        if(userRepository.findUserByEmail(email).isPresent()) {
            throw new AlreadyExistsException("User already exists!");
        }

        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setEmail(email);
        newUser.setPassword(password);

        userRepository.save(newUser);
    }

    private User findUserAccount(String email, String password) {
        User user = userRepository.findUser(email, password);
        if (user == null) {
            throw new NotFoundException("User does not exist");
        }

        return user;
    }

    public User getUserAccountDetails(String email, String password) {

        return findUserAccount(email, password);
    }

    @Transactional
    public void deleteUserAccount(String email, String password) {
        User user =  findUserAccount(email, password);

        userRepository.delete(user);
    }

    @Transactional
    public void updateUserAccountDetails(String email, String password,
                                         String updatedPassword, String updatedUsername) {
        User user = userRepository.findUser(email, password);

        if (user != null) {
            if (updatedPassword != null) {
                user.setPassword(updatedPassword);
            }
            if (updatedUsername != null) {
                user.setUserName(updatedUsername);
            }
        } else {
            throw new NotFoundException("User does not exist");
        }
    }

}
