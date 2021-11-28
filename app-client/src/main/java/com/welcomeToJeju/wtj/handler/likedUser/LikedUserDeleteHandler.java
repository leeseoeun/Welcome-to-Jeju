package com.welcomeToJeju.wtj.handler.likedUser;

import org.apache.ibatis.session.SqlSession;
import com.welcomeToJeju.util.Prompt;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.User;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;
import com.welcomeToJeju.wtj.handler.user.AuthLoginHandler;

public class LikedUserDeleteHandler implements Command {

  UserDao userDao;
  SqlSession sqlSession;

  public LikedUserDeleteHandler(UserDao userDao, SqlSession sqlSession) {
    this.userDao = userDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[유저 좋아요 취소하기]");

    String input = Prompt.inputString("닉네임(취소 : 엔터) > ");

    if (input.equals("") || input.length() == 0) {
      System.out.println("유저 좋아요 취소하기 취소!");
      return;
    }

    User user = userDao.findByNickname(input);

    if(user == null) {
      System.out.println("유저 없음!");
      return;
    }

    if(user.getNo() == AuthLoginHandler.getLoginUser().getNo()) {
      System.out.println("자기를 목록에서 뺄 수 없음!");
      return;
    }

    userDao.deleteLikedUser(user.getNo(), AuthLoginHandler.getLoginUser().getNo());
    sqlSession.commit();

    System.out.println("유저 좋아요 취소하기 성공!");
  }


}
