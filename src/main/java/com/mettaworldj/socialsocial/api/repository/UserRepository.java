package com.mettaworldj.socialsocial.api.repository;

import com.mettaworldj.socialsocial.api.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
    @Query("match (user:User{username:$currentUser}), (targetUser:User{username:$targetUser})"+
            "merge (user)-[isFollowing:IS_FOLLOWING]->(targetUser)")
    void followUser(String currentUser, String targetUser);

    @Query("match (user:User{username:$currentUser})-[isFollowing:IS_FOLLOWING]->(targetUser:User{username:$targetUser}) delete isFollowing")
    void unFollowUser(String currentUser, String targetUser);
}
