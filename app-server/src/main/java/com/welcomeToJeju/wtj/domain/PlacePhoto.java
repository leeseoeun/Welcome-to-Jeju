package com.welcomeToJeju.wtj.domain;

public class PlacePhoto {

  private int no;
  private String filePath;

  private Place place;
  private User writer;

  @Override
  public String toString() {
    return "PlacePhoto [no=" + no + ", filePath=" + filePath + ", place=" + place + ", writer="
        + writer + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
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
