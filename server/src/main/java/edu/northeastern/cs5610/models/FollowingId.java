package edu.northeastern.cs5610.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import javax.persistence.ManyToOne;

public class FollowingId implements Serializable {

  private int followerDuplicateId;
  private int followingId;

  public FollowingId() {
  }

  public FollowingId(int followerDuplicateId, int followingId) {
    this.followerDuplicateId = followerDuplicateId;
    this.followingId = followingId;
  }

  public int getFollowerDuplicateId() {
    return followerDuplicateId;
  }

  public void setFollowerDuplicateId(int followerDuplicateId) {
    this.followerDuplicateId = followerDuplicateId;
  }

  public int getFollowingId() {
    return followingId;
  }

  public void setFollowingId(int followingId) {
    this.followingId = followingId;
  }
}
