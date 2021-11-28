package com.welcomeToJeju.wtj.domain;

public class PlaceComment {

  private int no;
  private Place place;
  private User writer;
  private String comment;

  @Override
  public String toString() {
    return "PlaceComment [no=" + no + ", place=" + place + ", writer=" + writer + ", comment="
        + comment + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
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

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


}
