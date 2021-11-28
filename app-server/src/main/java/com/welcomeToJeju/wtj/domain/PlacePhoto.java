package com.welcomeToJeju.wtj.domain;

public class PlacePhoto {

  private int no;
  private Place place;
  private User writer;
  private String filePath;

  @Override
  public String toString() {
    return "PlacePhoto [no=" + no + ", place=" + place + ", writer=" + writer + ", filePath="
        + filePath + "]";
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

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }


}
