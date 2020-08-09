package edu.northeastern.cs5610.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Favorites {

  @Id
  @GeneratedValue
          (strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JsonIgnoreProperties("favoriteDetails")
  public User user;
  private String petId;

  public Favorites() {

  }

  public Favorites(User user, String petId) {
    this.user = user;
    this.petId = petId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getPetId() {
    return petId;
  }

  public void setPetId(String petId) {
    this.petId = petId;
  }

}
