package edu.northeastern.cs5610.models;

public enum Role {

  /*
  Insertion into db
  0 - for adopter
  1 - admin
  2 - facilitator
   */

  ADOPTER("1"), ADMIN("2"), FACILITATOR("3");

  Role(String s) {
  }

  Role() {
  }

  public static Role getRole(int id) {
    Role[] r = new Role[Role.values().length];
    r = Role.values();
    return r[id - 1];
  }

}

