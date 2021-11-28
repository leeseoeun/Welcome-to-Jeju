package com.welcomeToJeju.wtj.handler.ranking;

import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.User;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;

public class UserRankingHandler implements Command {
  UserDao userDao;

  public UserRankingHandler(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[유저 순위 보기]");

    // 탈퇴한 회원도 나옴
    int no = 1;
    for(User user : userDao.userRankingByViewCount()) {
      System.out.printf("%d위 > %s (조회수 : %d)\n", no++, user.getNickname(), user.getViewCount());
    }
  }


}
