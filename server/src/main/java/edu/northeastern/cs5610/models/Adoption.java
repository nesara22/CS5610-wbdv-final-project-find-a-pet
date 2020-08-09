package edu.northeastern.cs5610.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

import javax.persistence.*;

@Entity
@IdClass(AdoptionId.class)
public class Adoption {

  @Id
  @Column(nullable=false)
  private String petId;
  @Id
  private int userDuplicateId;
  private Status status = Status.REVIEW;


  @ManyToOne
  @JsonIgnoreProperties("adoptionDetails")
  public User user;

  private long created = System.currentTimeMillis();
  private long lastUpdated = System.currentTimeMillis();

  public Adoption() {

  }

  public Adoption(String petId, Status status, User user, long created, long lastUpdated) {
    this.petId = petId;
    this.userDuplicateId = user.getId();
    this.status = status;
    this.user = user;
    this.created = created;
    this.lastUpdated = lastUpdated;
  }


 /* public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }*/

  public String getPetId() {
    return petId;
  }

  public void setPetId(String petId) {
    this.petId = petId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public long getCreated() {
    return created;
  }

  public void setCreated(long created) {
    this.created = created;
  }

  public long getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(long lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public int getUserDuplicateId() {
    return userDuplicateId;
  }

  public void setUserDuplicateId(int userDuplicateId) {
    this.userDuplicateId = userDuplicateId;
  }
}
