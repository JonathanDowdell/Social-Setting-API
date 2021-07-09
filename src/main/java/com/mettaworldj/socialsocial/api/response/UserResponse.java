package com.mettaworldj.socialsocial.api.response;


import java.util.List;

public class UserResponse {

    private String email;

    private String username;

    private List<UserResponse> isFollowingList;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserResponse> getIsFollowingList() {
        return isFollowingList;
    }

    public void setIsFollowingList(List<UserResponse> isFollowingList) {
        this.isFollowingList = isFollowingList;
    }
}
