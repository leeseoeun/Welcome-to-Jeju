package com.welcomeToJeju.wtj.handler.ranking;

import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;

public class ThemeRankingHandler implements Command {

  ThemeDao themeDao;

  public ThemeRankingHandler(ThemeDao themeDao) {
    this.themeDao = themeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[테마 순위 보기]");

    // 비공개 테마도 나옴
    int no = 1;
    for(Theme theme : themeDao.themeRankingByViewCount()) {
      System.out.printf("%d위 > %s (조회수 : %d)\n", no++, theme.getTitle(), theme.getViewCount());
    }
  }


}
