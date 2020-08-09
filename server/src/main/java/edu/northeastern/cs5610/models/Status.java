package edu.northeastern.cs5610.models;

public enum Status {

  APPROVED("1"), DECLINED("2"), REVIEW("3");

/*
In the DB
0 - approved
1 - declined
2 - review
 */
  Status(String s) {

  }

  public static Status getStatus(int id) {
    Status[] s = new Status[Status.values().length];
    s = Status.values();
    return s[id-1];
  }

}
