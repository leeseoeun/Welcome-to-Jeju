package com.welcomeToJeju.wtj.handler.theme.myTheme;

import java.util.Collection;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;
import com.welcomeToJeju.wtj.handler.user.AuthLoginHandler;

public class MyThemeListHandler implements Command {

  ThemeDao themeDao;

  public MyThemeListHandler(ThemeDao themeDao) {
    this.themeDao = themeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception{
    System.out.println("[나의 테마 목록 보기]");

    Collection<Theme> themeList = themeDao.findByUserNo(AuthLoginHandler.getLoginUser().getNo());

    if (themeList.size() == 0) {
      System.out.println("테마 없음!");
      return;
    }

    int no = 1;
    for (Theme theme : themeList) {
      if (AuthLoginHandler.getLoginUser().getNo() == theme.getOwner().getNo()) {
        System.out.printf("<%d>\n", no++);
        System.out.printf("제목 > %s\n", theme.getTitle());
        System.out.printf("카테고리 > %s\n", theme.getCategory().getName());
        System.out.printf("해시태그 > %s\n", theme.getHashtags().toString());

        if (theme.getIsPublic() == 1) {
          System.out.println("공개 테마");
          System.out.printf("조회수 > %s\n", theme.getViewCount());
        } else {
          System.out.println("비공개 테마");
        }
      }
    }
  }


}
