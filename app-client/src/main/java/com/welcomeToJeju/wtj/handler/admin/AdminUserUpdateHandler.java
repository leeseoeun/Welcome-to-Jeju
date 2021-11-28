package com.welcomeToJeju.wtj.handler.admin;

import org.apache.ibatis.session.SqlSession;
import com.welcomeToJeju.util.Prompt;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.User;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;

public class AdminUserUpdateHandler implements Command {

  UserDao userDao;
  SqlSession sqlSession;

  public AdminUserUpdateHandler(UserDao userDao, SqlSession sqlSession) {
    this.userDao = userDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[회원 수정하기]");

    User user = (User) request.getAttribute("user");

    String nickname = Prompt.inputString(String.format("닉네임(%s) > ", user.getNickname()));
    String password = Prompt.inputString("비밀번호 > ");

    String input = Prompt.inputString("수정하기(y/N) > ");

    if (input.equalsIgnoreCase("n") | input.length() == 0) {
      System.out.println("회원 수정하기 취소!");
      return;
    }

    user.setNickname(nickname);
    user.setPassword(password);

    userDao.update(user);
    sqlSession.commit();

    System.out.println("회원 수정하기 성공!");
  }


}
