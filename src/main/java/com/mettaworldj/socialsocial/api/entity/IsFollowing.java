package com.mettaworldj.socialsocial.api.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.Date;

@RelationshipProperties
public class IsFollowing {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "follow_date")
    private Date followDate;

    @TargetNode
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFollowDate() {
        return followDate;
    }

    public void setFollowDate(Date followDate) {
        this.followDate = followDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
