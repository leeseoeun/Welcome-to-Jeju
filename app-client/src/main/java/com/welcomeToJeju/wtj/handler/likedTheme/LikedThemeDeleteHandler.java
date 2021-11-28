package com.welcomeToJeju.wtj.handler.likedTheme;

import org.apache.ibatis.session.SqlSession;
import com.welcomeToJeju.util.Prompt;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;
import com.welcomeToJeju.wtj.handler.user.AuthLoginHandler;

public class LikedThemeDeleteHandler implements Command {

  ThemeDao themeDao;
  SqlSession sqlSession;

  public LikedThemeDeleteHandler(ThemeDao themeDao, SqlSession sqlSession) {
    this.themeDao = themeDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[테마 좋아요 취소하기]");

    String title = Prompt.inputString("테마(취소 : 엔터) > ");

    if (title.equals("") || title.length() == 0) {
      System.out.println("테마 좋아요 취소하기 취소!");
      return;
    }

    Theme theme = themeDao.findByTitle(title);

    //    while(true) {
    //      String input = Prompt.inputString("정말로 삭제 하시겠습니까?(y/N) : ");
    //      if(input.equalsIgnoreCase("y")) {
    //        break;
    //      } else if (input.equalsIgnoreCase("n")) {
    //        System.out.println("삭제 취소");
    //        return;
    //      } else {
    //        System.out.println("잘못된 입력입니다. 다시 입력하세요.");
    //        continue;
    //      }
    //    }

    themeDao.deleteLikedTheme(theme.getNo(), AuthLoginHandler.getLoginUser().getNo());
    sqlSession.commit();

    System.out.println("테마 좋아요 취소하기 성공!");
  }


}
