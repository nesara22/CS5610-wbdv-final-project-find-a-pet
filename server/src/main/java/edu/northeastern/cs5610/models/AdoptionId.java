package edu.northeastern.cs5610.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import javax.persistence.ManyToOne;

public class AdoptionId implements Serializable {

  private String petId;
  private int userDuplicateId;

  public AdoptionId() {

  }

  public AdoptionId(String petId, int userDuplicateId) {
    this.petId = petId;
    this.userDuplicateId = userDuplicateId;
  }

  public String getPetId() {
    return petId;
  }

  public void setPetId(String petId) {
    this.petId = petId;
  }

  public int getUserDuplicateId() {
    return userDuplicateId;
  }

  public void setUserDuplicateId(int userDuplicateId) {
    this.userDuplicateId = userDuplicateId;
  }
}
