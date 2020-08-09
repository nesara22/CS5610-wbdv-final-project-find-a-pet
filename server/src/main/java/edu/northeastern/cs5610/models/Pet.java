package edu.northeastern.cs5610.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pet {
  @Id
  @GeneratedValue
          (strategy = GenerationType.IDENTITY)
  private int id;
  private String petName;
  private String petType;
  private String petColor;
  private String gender;
  private String imageUrl;

  public Pet(){

  }
  public Pet(String petName, String petType, String petColor, String gender, String imageUrl) {
    this.petName = petName;
    this.petType = petType;
    this.petColor = petColor;
    this.gender = gender;
    this.imageUrl = imageUrl;
  }

  public int getId() {
    return id;
  }

  public String getPetName() {
    return petName;
  }

  public String getPetType() {
    return petType;
  }

  public String getPetColor() {
    return petColor;
  }

  public String getGender() {
    return gender;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setPetName(String petName) {
    this.petName = petName;
  }

  public void setPetType(String petType) {
    this.petType = petType;
  }

  public void setPetColor(String petColor) {
    this.petColor = petColor;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
