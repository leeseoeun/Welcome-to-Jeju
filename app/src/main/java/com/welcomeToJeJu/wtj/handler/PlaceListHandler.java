package com.welcomeToJeJu.wtj.handler;

import com.welcomeToJeJu.wtj.domain.Place;
import com.welcomeToJeJu.wtj.domain.Theme;

public class PlaceListHandler extends AbstractPlaceHandler{

  @Override
  public void execute(CommandRequest request) {
    while (true) {
      System.out.println("[장소 목록 보기]");

      Theme theme = (Theme) request.getAttribute("searchedTheme");

      System.out.printf("[%s] 테마 이름 > %s\n", theme.getCategory(), theme.getTitle());

      int index = 1;
      for (Place place : theme.getPlaceList()) {
        System.out.printf("<%d>\n", index++);
        System.out.printf("장소 이름 > %s\n", place.getStoreName());
        System.out.printf("장소 주소 > %s\n", place.getStoreAddress());
        System.out.printf("위도 > %s\n", place.getxCoord());
        System.out.printf("경도 > %s\n", place.getyCoord());
        System.out.printf("장소 후기> %s\n", place.getComments().toString());
        System.out.println();
      }
    }
  }


}
