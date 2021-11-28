package com.welcomeToJeju.wtj.handler.user;

import com.welcomeToJeju.util.Prompt;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.User;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;

public class AuthUserInfoHandler implements Command {

  UserDao userDao;

  public AuthUserInfoHandler(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[내 정보]");

    User user = userDao.findByNo(AuthLoginHandler.loginUser.getNo());

    System.out.printf("이메일 > %s\n", user.getEmail());
    System.out.printf("닉네임 > %s\n", user.getNickname());
    System.out.printf("가입일 > %s\n", user.getRegisteredDate());
    System.out.printf("🚨 경고 > %s\n", user.getWarningCount());

    request.setAttribute("loginUser", AuthLoginHandler.getLoginUser());

    String input = Prompt.inputString("수정하기(U) / 탈퇴하기(D) / 취소(0) > ");

    switch (input) {
      case "U" :
      case "u" :
        request.getRequestDispatcher("/user/update").forward(request);
        return;

      case "D" :
      case "d" :
        request.getRequestDispatcher("/user/delete").forward(request);
        return;

      case "0" :
        return;

      default :
        System.out.println("올바르지 않은 명령!");
    }
  }


}
