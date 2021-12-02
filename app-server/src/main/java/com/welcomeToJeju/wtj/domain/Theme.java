package com.welcomeToJeju.wtj.domain;

import java.util.ArrayList;
import java.util.List;

public class Theme implements Comparable<Theme> {

  private int no;
  private String title;
  private User owner;
  private ThemeCategory category;
  private int isPublic;
  private int isShare;

  private String emoji;

  private int viewCount;

  //  private List<String> hashtags = new ArrayList<>();
  private List<Place> placeList = new ArrayList<>();

  @Override
  public String toString() {
    return "Theme [no=" + no + ", title=" + title + ", owner=" + owner + ", category=" + category
        + ", isPublic=" + isPublic + ", isShare=" + isShare + ", emoji=" + emoji + ", viewCount="
        + viewCount + /* ", hashtags=" + hashtags + */ ", placeList=" + placeList + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public ThemeCategory getCategory() {
    return category;
  }

  public void setCategory(ThemeCategory category) {
    this.category = category;
  }

  public int getIsPublic() {
    return isPublic;
  }

  public void setIsPublic(int isPublic) {
    this.isPublic = isPublic;
  }

  public int getIsShare() {
    return isShare;
  }

  public void setIsShare(int isShare) {
    this.isShare = isShare;
  }

  public String getEmoji() {
    return emoji;
  }

  public void setEmoji(String emoji) {
    this.emoji = emoji;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  //  public List<String> getHashtags() {
  //    return hashtags;
  //  }
  //
  //  public void setHashtags(List<String> hashtags) {
  //    this.hashtags = hashtags;
  //  }

  public List<Place> getPlaceList() {
    return placeList;
  }

  public void setPlaceList(List<Place> placeList) {
    this.placeList = placeList;
  }

  @Override
  public int compareTo(Theme theme) {
    return theme.viewCount - this.viewCount;
  }


}
