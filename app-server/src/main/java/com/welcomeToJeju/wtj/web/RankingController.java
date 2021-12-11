package com.welcomeToJeju.wtj.web;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.PublicThemeDao;
import com.welcomeToJeju.wtj.dao.ShareThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class RankingController {

  @Autowired PublicThemeDao publicThemeDao;
  @Autowired ShareThemeDao shareThemeDao;
  @Autowired UserDao userDao;

  @GetMapping("/ranking")
  public ModelAndView ranking() throws Exception {

    Collection<Theme> publicThemeList = publicThemeDao.themeRanking10();
    Collection<Theme> shareThemeList = shareThemeDao.themeRanking10();
    Collection<User> userList = userDao.userRanking10();

    ModelAndView mv = new ModelAndView();
    mv.addObject("publicThemeList", publicThemeList);
    mv.addObject("shareThemeList", shareThemeList);
    mv.addObject("userList", userList);
    mv.addObject("pageTitle", "순위 보기");
    mv.addObject("contentUrl", "ranking/Ranking2.jsp");
    mv.setViewName("template_main");

    return mv;
  }


}
