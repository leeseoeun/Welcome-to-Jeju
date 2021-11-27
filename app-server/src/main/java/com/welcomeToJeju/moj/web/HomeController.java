package com.welcomeToJeju.moj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.welcomeToJeju.moj.dao.PlaceDao;
import com.welcomeToJeju.moj.dao.ThemeDao;
import com.welcomeToJeju.moj.dao.UserDao;

@Controller
public class HomeController {

  @Autowired ThemeDao themeDao;
  @Autowired UserDao userDao;
  @Autowired PlaceDao placeDao;

  @GetMapping("/home")
  public String home(Model model/* , HttpSession session */) throws Exception {
    model.addAttribute("themeRanking10", themeDao.themeRanking10());
    model.addAttribute("userRanking10", userDao.userTop10());
    model.addAttribute("placeRaking10", placeDao.findTop10());
    model.addAttribute("newTheme10", themeDao.newTheme10());
    model.addAttribute("themeList", themeDao.findAllPublicTheme());

    return "home/Home";
  }


}
