package com.RecipeFinderBackend.RecipeFinder.users;

import com.RecipeFinderBackend.RecipeFinder.exceptions.UserNotLoggedIn;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="api/users")
public class UserController {
    private UserService userService;

    // Constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public void userLogIn(@RequestParam String userEmail, @RequestParam String userPassword) {
        userService.userLogIn(userEmail, userPassword);
    }


    @PostMapping("/logout")
    public void userLogsOut() {
        userService.userLogsOut();
    }


    @GetMapping("/user-account-details")
    public User getUserAccountDetails() {
        if (userService.isUserLoggedIn()) {
            String email = userService.getLoggedInUser().getEmail();
            String password = userService.getLoggedInUser().getPassword();
            return userService.getUserAccountDetails(email, password);
        } else {
            throw new UserNotLoggedIn("Please log in to view your profile");
        }
    }


    @PostMapping("/new-account")
    public void addNewUser(@RequestParam String userName,
                           @RequestParam String userEmail,
                           @RequestParam String userPassword) {

        userService.addNewUser(userName, userEmail, userPassword);

    }


    @DeleteMapping("/delete-account")
    public void deleteUserAccount(@RequestParam String email,
                                  @RequestParam String password) {

        userService.deleteUserAccount(email, password);
    }


    @PutMapping("/update-account-details")
    public void updateUserAccountDetails(@RequestParam String email,
                                         @RequestParam String password,
                                         @RequestParam(required = false) String updatedPassword,
                                         @RequestParam(required = false) String updatedUsername) {

        userService.updateUserAccountDetails(email, password, updatedPassword, updatedUsername);
    }
}

