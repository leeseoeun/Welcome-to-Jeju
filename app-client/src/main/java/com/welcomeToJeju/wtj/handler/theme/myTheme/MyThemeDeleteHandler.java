package com.welcomeToJeju.wtj.handler.theme.myTheme;

import org.apache.ibatis.session.SqlSession;
import com.welcomeToJeju.util.Prompt;
import com.welcomeToJeju.wtj.dao.PlaceDao;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;

public class MyThemeDeleteHandler implements Command {

  ThemeDao themeDao;
  SqlSession sqlSession;
  PlaceDao placeDao;

  public MyThemeDeleteHandler(ThemeDao themeDao,PlaceDao placeDao, SqlSession sqlSession) {
    this.themeDao = themeDao;
    this.sqlSession = sqlSession;
    this.placeDao = placeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception{
    System.out.println("[나의 테마 삭제하기]");

    Theme theme = (Theme) request.getAttribute("theme");

    String input = Prompt.inputString("삭제하기(y/N) > ");

    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("나의 테마 삭제하기 취소!");
      return;
    }

    try {
      themeDao.deleteAllLikedThemeByThemeNo(theme.getNo());
      themeDao.deleteHashtag(theme.getNo());
      themeDao.deletePlaceUserTheme(theme.getNo());
      themeDao.delete(theme.getNo());
      sqlSession.commit();
      System.out.println("나의 테마 삭제하기 성공!");

    } catch (Exception e) {
      System.out.println(e);
      sqlSession.rollback();
      System.out.println("나의 테마 삭제하기 실패!");
    }
  }


}
