package com.welcomeToJeju.wtj.handler.likedTheme;


import java.util.Collection;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;
import com.welcomeToJeju.wtj.handler.user.AuthLoginHandler;

public class LikedThemeListHandler implements Command{

  ThemeDao themeDao;

  public LikedThemeListHandler(ThemeDao themeDao) {
    this.themeDao = themeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[테마 좋아요 목록 보기]");

    Collection<Theme> themeList = themeDao.findAllLikedTheme(AuthLoginHandler.getLoginUser().getNo());

    int no = 1;
    for (Theme theme : themeList) {
      System.out.printf("<%d> '%s' 님의 '%s' 테마\n",
          no++, theme.getOwner().getNickname(), theme.getTitle());
    }
  }


}
