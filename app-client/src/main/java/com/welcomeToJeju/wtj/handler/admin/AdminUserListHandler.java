package com.welcomeToJeju.wtj.handler.admin;

import java.util.Collection;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.User;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;

public class AdminUserListHandler implements Command {

  UserDao userDao;

  public AdminUserListHandler(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[회원 목록 보기]");

    Collection<User> userList = userDao.findAll();

    if (userList.size() == 0) {
      System.out.println("회원 없음!");
      return;
    }


    for (User user : userList) {
      String status = user.getActive() == 0 ? "탈퇴" : "회원";
      System.out.printf("<%d> %s, %s, %s, 🚨 %d, %s\n",
          user.getNo(),
          user.getEmail(),
          user.getNickname(),
          user.getRegisteredDate(),
          user.getWarningCount(),
          status);
    }
  }


}
