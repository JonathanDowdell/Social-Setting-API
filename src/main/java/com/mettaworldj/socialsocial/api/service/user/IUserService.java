package com.mettaworldj.socialsocial.api.service.user;

import com.mettaworldj.socialsocial.api.entity.User;
import com.mettaworldj.socialsocial.api.request.CreateUserRequest;
import com.mettaworldj.socialsocial.api.response.UserResponse;

public interface IUserService {
    UserResponse createUser(CreateUserRequest createUserRequest);
    void followUser(String currentUsername, String targetUser);
    void unFollowUser(String currentUsername, String targetUser);

    UserResponse getUserById(Long id);
}
