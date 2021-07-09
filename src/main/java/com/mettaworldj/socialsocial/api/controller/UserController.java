package com.mettaworldj.socialsocial.api.controller;

import com.mettaworldj.socialsocial.api.request.CreateUserRequest;
import com.mettaworldj.socialsocial.api.response.UserResponse;
import com.mettaworldj.socialsocial.api.service.user.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/follow/{currentUser}/{targetUser}")
    public void followUser(@PathVariable String currentUser, @PathVariable String targetUser) {
        userService.followUser(currentUser, targetUser);
    }

    @GetMapping("/unfollow/{currentUser}/{targetUser}")
    public void unFollowUser(@PathVariable String currentUser, @PathVariable String targetUser) {
        userService.unFollowUser(currentUser, targetUser);
    }

}
