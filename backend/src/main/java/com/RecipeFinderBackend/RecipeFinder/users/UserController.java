package com.RecipeFinderBackend.RecipeFinder.users;

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
    public void userLogIn(@RequestParam String email, @RequestParam String password) {
        userService.userLogIn(email, password);
    }

    @PostMapping("/logout")
    public void userLogsOut() {
        userService.userLogsOut();
    }

    @GetMapping("/user-account-details")
    public User getUserAccountDetails(@RequestParam String email,
                                      @RequestParam String password) {

        return userService.getUserAccountDetails(email, password);
    }


    @PostMapping("/new-account")
    public void addNewUser(@RequestParam String userName,
                           @RequestParam String email,
                           @RequestParam String password) {

        userService.addNewUser(userName, email, password);

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

