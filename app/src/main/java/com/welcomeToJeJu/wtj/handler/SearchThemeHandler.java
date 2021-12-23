package com.welcomeToJeJu.wtj.handler;

import java.util.List;
import com.welcomeToJeJu.util.Prompt;
import com.welcomeToJeJu.wtj.domain.Theme;
import com.welcomeToJeJu.wtj.domain.User;

public class SearchThemeHandler extends AbstractSearchHandler {

  List<Theme> themeList;

  public SearchThemeHandler(List<User> userList, List<Theme> themeList) {
    super(userList);
    this.themeList = themeList;
  } 

  @Override
  public void execute(CommandRequest request) {

    System.out.println("[테마 검색하기]");

    while (true) {
      String input = Prompt.inputString("테마 이름(취소 : 엔터) > ");

      if(input.equalsIgnoreCase("") || input.length() == 0) {
        System.out.println("테마 검색하기 취소!");
        return;
      }

      for (Theme theme : themeList) {
        if (theme.getTitle().contains(input) && theme.isPublic()) { // 테마 이름에 'input'이 있다면
          System.out.printf("[%s] 테마 이름 > %s\n", theme.getCategory(), theme.getTitle());
          System.out.printf("해시 태그 > %s\n", theme.getHashtags().toString());
          System.out.printf("조회수 > %d\n", theme.getViewCount() + 1);    // 테마 검색 시 조회수+1
          System.out.println();
          return;
        }
      }

      System.out.println("해당하는 테마 없음!");
    }
  }


}
