package edu.northeastern.cs5610.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {

  @Id
  @GeneratedValue
          (strategy = GenerationType.IDENTITY)
  private int id;
  @Column(unique = true, nullable = false)
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String address;
  private Role role;
  private long lastUpdated = System.currentTimeMillis();
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JsonIgnoreProperties("user")
  private List<Adoption> adoptionDetails;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @Fetch(value = FetchMode.SUBSELECT)
  @JsonIgnoreProperties("user")
  private List<Favorites> favoriteDetails;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @Fetch(value = FetchMode.SUBSELECT)
  @JsonIgnore
  //@JsonIgnoreProperties("follower")
  private List<Favorites> followingDetails;

  public User() {

  }

  public User(String username, String password, String firstName, String lastName, String email, String phone, String address, Role role, long lastUpdated, List<Adoption> adoptionDetails, List<Favorites> favoriteDetails, List<Favorites> followingDetails) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.role = role;
    this.lastUpdated = lastUpdated;
    this.adoptionDetails = adoptionDetails;
    this.favoriteDetails = favoriteDetails;
    this.followingDetails = followingDetails;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public long getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(long lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public List<Adoption> getAdoptionDetails() {
    return adoptionDetails;
  }

  public void setAdoptionDetails(List<Adoption> adoptionDetails) {
    this.adoptionDetails = adoptionDetails;
  }

  public List<Favorites> getFavoriteDetails() {
    return favoriteDetails;
  }

  public void setFavoriteDetails(List<Favorites> favoriteDetails) {
    this.favoriteDetails = favoriteDetails;
  }

  public List<Favorites> getFollowingDetails() {
    return followingDetails;
  }

  public void setFollowingDetails(List<Favorites> followingDetails) {
    this.followingDetails = followingDetails;
  }
}
