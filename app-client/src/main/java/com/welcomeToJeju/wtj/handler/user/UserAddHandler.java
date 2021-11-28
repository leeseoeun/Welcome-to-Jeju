package com.welcomeToJeju.wtj.handler.user;

import org.apache.ibatis.session.SqlSession;
import com.welcomeToJeju.util.Prompt;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.User;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;

public class UserAddHandler implements Command {

  UserDao userDao;
  SqlSession sqlSession;

  public UserAddHandler(UserDao userDao, SqlSession sqlSession) {
    this.userDao = userDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[회원 가입]");

    User user = new User();

    user.setEmail(Prompt.inputString("이메일 > "));
    user.setPassword(Prompt.inputString("비밀번호 > "));
    user.setNickname(Prompt.inputString("닉네임 > "));

    try {
      userDao.insert(user);
      sqlSession.commit();
      System.out.println("회원 가입 성공!");

    } catch (Exception e) {
      System.out.println(
          e.getCause().toString().contains("UIX_email") ?
              "이메일 중복!" : "닉네임 중복!");
      return;
    }
  }


}
