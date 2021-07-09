package com.mettaworldj.socialsocial.api.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node(labels = "Post")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
