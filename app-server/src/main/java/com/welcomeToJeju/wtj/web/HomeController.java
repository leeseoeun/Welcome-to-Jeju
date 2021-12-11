package com.welcomeToJeju.wtj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.welcomeToJeju.wtj.dao.PlaceDao;
import com.welcomeToJeju.wtj.dao.PublicThemeDao;
import com.welcomeToJeju.wtj.dao.ShareThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;

@Controller
public class HomeController {

  @Autowired PublicThemeDao publicThemeDao;
  @Autowired ShareThemeDao shareThemeDao;
  @Autowired UserDao userDao;
  @Autowired PlaceDao placeDao;

  @GetMapping("/home")
  public String home(Model model/* , HttpSession session */) throws Exception {
    model.addAttribute("userRanking10", userDao.userRanking10());
    model.addAttribute("placeRanking10", placeDao.placeRanking10());
    model.addAttribute("shareThemeRanking10", shareThemeDao.themeRanking10());
    model.addAttribute("publicThemeRanking10", publicThemeDao.themeRanking10());
    model.addAttribute("newPublicTheme10", publicThemeDao.newTheme10());
    model.addAttribute("newShareTheme10", shareThemeDao.newTheme10());
    model.addAttribute("publicThemeList", publicThemeDao.findAllPublicTheme());
    model.addAttribute("shareThemeList", shareThemeDao.findAllShareTheme());

    return "home/Home"; // 뷰를 호출해야 되니까
  }


}
