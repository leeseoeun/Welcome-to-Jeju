package com.welcomeToJeJu.wtj.handler;

import com.welcomeToJeJu.util.Prompt;
import com.welcomeToJeJu.wtj.domain.Place;
import com.welcomeToJeJu.wtj.domain.Theme;

public class PlaceDeleteHandler extends AbstractPlaceHandler{

  @Override
  public void execute(CommandRequest request) {
    while (true) {
      System.out.println("[장소 삭제하기]");

      Theme theme = (Theme) request.getAttribute("searchedTheme");

      String storeName = Prompt.inputString("장소 이름(취소 : 엔터) > ");

      if (storeName.equalsIgnoreCase("") || storeName.length() == 0) {
        System.out.println("장소 삭제하기 취소!");
        return;
      }

      Place place = null;
      for (Place list : theme.getPlaceList()) {
        if (list.getStoreName().equals(storeName)) {
          place = list;
          break;
        }
      }

      if (place == null) {
        System.out.println("등록된 장소 없음!");
        System.out.println();
        continue;
      }

      String input = Prompt.inputString("삭제하기(y/N) > ");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("장소 삭제하기 취소!");
        return;
      }

      theme.getPlaceList().remove(place);
      System.out.println("장소 삭제하기 성공!");
    }
  }


}
