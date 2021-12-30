package com.welcomeToJeju.util;

public class KakaoVo {
  private String id;
  private String place_name;
  private String address_name;
  private String x;
  private String y;

  @Override
  public String toString() {
    return "KakaoVo [id=" + id + ", place_name=" + place_name + ", address_name=" + address_name
        + ", x=" + x + ", y=" + y + "]";
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPlace_name() {
    return place_name;
  }
  public void setPlace_name(String place_name) {
    this.place_name = place_name;
  }
  public String getAddress_name() {
    return address_name;
  }
  public void setAddress_name(String address_name) {
    this.address_name = address_name;
  }
  public String getX() {
    return x;
  }
  public void setX(String x) {
    this.x = x;
  }
  public String getY() {
    return y;
  }
  public void setY(String y) {
    this.y = y;
  }


}
