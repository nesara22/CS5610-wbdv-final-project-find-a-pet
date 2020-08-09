package edu.northeastern.cs5610.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(FollowingId.class)
public class Following {

  @ManyToOne
  @JsonIgnoreProperties("followingDetails")
  private User follower;

  @Id
  @Column(nullable = false)
  private int followerDuplicateId;
  @Id
  @Column(nullable = false)
  private int followingId;


  public Following() {
  }

  public Following(int followerDuplicateId, int followingId, User follower) {
    this.followerDuplicateId = follower.getId();
    this.followingId = followingId;
    this.follower = follower;
  }

  public int getFollowingId() {
    return followingId;
  }

  public void setFollowingId(int followingId) {
    this.followingId = followingId;
  }

  public int getFollowerDuplicateId() {
    return followerDuplicateId;
  }

  public void setFollowerDuplicateId(int followerDuplicateId) {
    this.followerDuplicateId = followerDuplicateId;
  }

  public User getFollower() {
    return follower;
  }

  public void setFollower(User follower) {
    this.follower = follower;
  }
}
