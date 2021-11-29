package com.welcomeToJeju.wtj.domain;

public class PlaceComment {

  private int no;
  private String comment;

  private Place place;
  private User writer;

  @Override
  public String toString() {
    return "PlaceComment [no=" + no + ", comment=" + comment + ", place=" + place + ", writer="
        + writer + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Place getPlace() {
    return place;
  }

  public void setPlace(Place place) {
    this.place = place;
  }

  public User getWriter() {
    return writer;
  }

  public void setWriter(User writer) {
    this.writer = writer;
  }


}
