package com.welcomeToJeju.wtj.handler.admin;

import org.apache.ibatis.session.SqlSession;
import com.welcomeToJeju.util.Prompt;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.User;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;

public class AdminUserDeleteHandler implements Command {

  UserDao userDao;
  ThemeDao themeDao;
  SqlSession sqlSession;

  public AdminUserDeleteHandler(UserDao userDao, ThemeDao themeDao, SqlSession sqlSession) {
    this.userDao = userDao;
    this.sqlSession = sqlSession;
    this.themeDao = themeDao;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[회원 삭제하기]");

    User user = (User) request.getAttribute("user");

    String input = Prompt.inputString("삭제하기(y/N) > ");

    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제하기 취소!");
      return;
    }

    try {
      themeDao.deleteAllLikedThemeByUserNo(user.getNo());
      userDao.deleteAllLikedUser(user.getNo());
      userDao.updateActive(user.getNo());
      sqlSession.commit();
      System.out.println("회원 삭제하기 성공!");

    } catch (Exception e) {
      System.out.println(e);
      System.out.println("회원 삭제하기 실패!");
      sqlSession.rollback();
    }
  }


}
