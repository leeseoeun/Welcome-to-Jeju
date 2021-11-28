package com.welcomeToJeju.wtj.handler.search;

import java.util.ArrayList;
import java.util.List;
import com.welcomeToJeju.util.Prompt;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;

public class SearchHashtagHandler implements Command {

  ThemeDao themeDao;
  UserDao userDao;

  public SearchHashtagHandler(ThemeDao themeDao, UserDao userDao) {
    this.themeDao = themeDao;
    this.userDao = userDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[해시태그 검색하기]");

    while (true) {
      String input = Prompt.inputString("해시태그(취소 : 엔터) > ");

      if(input.equals("") || input.length() == 0) {
        System.out.println("해시태그 검색하기 취소!");
        return;
      }

      ArrayList<Theme> themeList = (ArrayList<Theme>) themeDao.findByHashtag(input);

      if (themeList.size() == 0) {
        System.out.println("테마 없음!");
        continue;   //*다시 입력받기
      }

      System.out.printf("[%s] 검색 결과\n", input);
      printList(themeList);

      return;
    }
  }

  private void printList(List<Theme> themeList) throws Exception {
    // 닉네임 안 됨
    int no = 1;
    for (Theme theme : themeList) {
      System.out.printf("<%d> '%s' 님의 '%s' 테마\n",
          no++, theme.getOwner().getNickname(), theme.getTitle());
    }
  }


}
