package com.welcomeToJeju.wtj.handler.search;

import java.util.Collection;
import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import com.welcomeToJeju.util.Prompt;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.User;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;

public class SearchUserHandler implements Command {

  UserDao userDao;
  ThemeDao themeDao;
  SqlSession sqlSession;

  public SearchUserHandler(UserDao userDao, ThemeDao themeDao, SqlSession sqlSession) {
    this.userDao = userDao;
    this.themeDao = themeDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[유저 검색하기]");

    while (true) {
      String input = Prompt.inputString("닉네임(취소 : 엔터) > ");

      if(input.equals("") || input.length() == 0) {
        System.out.println("유저 검색하기 취소!");
        return;
      }

      User user = userDao.findByNickname(input);

      if(user == null) {
        System.out.println("유저 없음!");
        continue;
      }

      // 조회수 +1
      int viewCount = user.getViewCount();
      HashMap<String,Object> params = new HashMap<>();
      params.put("userNo", user.getNo());
      params.put("viewCnt", viewCount + 1);
      userDao.updateViewCount(params);
      sqlSession.commit();

      System.out.printf("[%s] 검색 결과\n", user.getNickname());
      printList(user);

      return;
    }
  }

  private void printList(User user) throws Exception {
    Collection<Theme> themeList = themeDao.findByUserNo(user.getNo());

    int no = 1;
    for(Theme theme : themeList) {
      System.out.printf("<%d> %s\n", no++, theme.getTitle());
    }
  }


}
