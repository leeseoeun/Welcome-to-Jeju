package com.welcomeToJeJu.wtj.handler;

import java.util.List;
import com.welcomeToJeJu.wtj.domain.Theme;
import com.welcomeToJeJu.wtj.domain.User;

public class AllThemeListHandler extends AbstractSearchHandler {

  public AllThemeListHandler(List<User> userList) {
    super(userList);
  }

  @Override
  public void execute(CommandRequest request) {
    System.out.println("[전체 테마 목록 보기]");

    int i = 1;
    for(User user : userList) {
      for(Theme theme : user.getThemeList()) {
        if(!theme.isPublic()) continue;

        System.out.printf("<%d>\n",i++);
        System.out.println("테마 이름 > " + theme.getTitle());
        System.out.println("해시 태그 > " + theme.getHashtags().toString());
      }
    }
  }


}
