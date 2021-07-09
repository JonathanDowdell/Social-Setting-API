package com.mettaworldj.socialsocial.api.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node(labels = {"User"})
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String username;

    @Property(name = "encrypted_password")
    private String encryptedPassword;

    @Relationship(type = "IS_FOLLOWING", direction = Relationship.Direction.OUTGOING)
    private List<IsFollowing> isFollowingList;

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
    private List<Post> postList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public List<IsFollowing> getIsFollowingList() {
        return isFollowingList;
    }

    public void setIsFollowingList(List<IsFollowing> isFollowingList) {
        this.isFollowingList = isFollowingList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
