package com.mettaworldj.socialsocial.api.service.user;


import com.mettaworldj.socialsocial.api.entity.User;
import com.mettaworldj.socialsocial.api.repository.UserRepository;
import com.mettaworldj.socialsocial.api.request.CreateUserRequest;
import com.mettaworldj.socialsocial.api.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setUsername(createUserRequest.getUsername());
        user.setEncryptedPassword(createUserRequest.getPassword());
        User savedUser = userRepository.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setUsername(savedUser.getUsername());
        return userResponse;
    }

    @Override
    public void followUser(String currentUsername, String targetUser) {
        userRepository.followUser(currentUsername, targetUser);
    }

    @Override
    public void unFollowUser(String currentUsername, String targetUser) {
        userRepository.unFollowUser(currentUsername, targetUser);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).get();
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        List<UserResponse> userResponses = user.getIsFollowingList().stream().map((item) -> {
            User user1 = item.getUser();
            UserResponse userResponse1 = new UserResponse();
            userResponse1.setUsername(user1.getUsername());
            userResponse1.setEmail(user1.getEmail());
            return userResponse1;
        }).collect(Collectors.toList());
        userResponse.setIsFollowingList(userResponses);
        return userResponse;
    }
}
