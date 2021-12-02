package com.welcomeToJeju.wtj.web;

import java.util.Collection;
import org.apache.ibatis.session.SqlSessionFactory;
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
public class SearchController {

  @Autowired UserDao userDao;
  @Autowired PublicThemeDao publicThemeDao;
  @Autowired ShareThemeDao shareThemeDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @GetMapping("/search/theme")
  public ModelAndView searchTheme(String keyword) throws Exception {
    Collection<Theme> publicThemeList = publicThemeDao.findByKeyword(keyword);
    Collection<Theme> shareThemeList = shareThemeDao.findByKeyword(keyword);

    ModelAndView mv = new ModelAndView();
    mv.addObject("publicThemeList", publicThemeList);
    mv.addObject("shareThemeList", shareThemeList);
    mv.addObject("keyword", keyword);
    mv.addObject("pageTitle", "테마 검색 목록 보기");
    mv.addObject("contentUrl", "search/SearchTheme.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  @GetMapping("/search/user")
  public ModelAndView searchUser(String keyword) throws Exception {
    Collection<User> userList = userDao.findByKeyword(keyword);

    ModelAndView mv = new ModelAndView();
    mv.addObject("userList", userList);
    mv.addObject("keyword", keyword);
    mv.addObject("pageTitle", "유저 검색 목록 보기");
    mv.addObject("contentUrl", "search/SearchUser.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  @GetMapping("/search/all")
  public ModelAndView searchAll(String keyword, String option) throws Exception {
    Collection<Theme> publicThemeList = publicThemeDao.findByKeyword(keyword);
    Collection<Theme> shareThemeList = shareThemeDao.findByKeyword(keyword);
    Collection<User> userList = userDao.findByKeyword(keyword);

    ModelAndView mv = new ModelAndView();
    mv.addObject("publicThemeList", publicThemeList);
    mv.addObject("shareThemeList", shareThemeList);
    mv.addObject("userList", userList);
    mv.addObject("keyword", keyword);
    mv.addObject("pageTitle", "검색 목록 보기");

    if (option.equals("all")) {
      mv.addObject("contentUrl", "search/Search.jsp");

    } else if (option.equals("theme")) {
      mv.addObject("contentUrl", "search/SearchTheme.jsp");

    } else if (option.equals("user")){
      mv.addObject("contentUrl", "search/SearchUser.jsp");
    }
    mv.setViewName("template_main");

    return mv;
  }

  // 메서드명, url 경로명 상의하기
  @GetMapping("/search/sidebar")
  public ModelAndView searchSidebar(String keyword) throws Exception {

    Collection<User> userList = userDao.findByKeyword(keyword);
    Collection<Theme> themeList = publicThemeDao.findByKeyword(keyword);

    ModelAndView mv = new ModelAndView();
    mv.addObject("userList", userList);
    mv.addObject("themeList", themeList);
    mv.addObject("keyword", keyword);
    mv.addObject("pageTitle", "통합 검색 목록보기");
    mv.addObject("contentUrl", "search/SearchSidebar.jsp");
    mv.setViewName("template_main");
    return mv;

  }

  // 메서드명, url 경로명 상의하기
  @GetMapping("/search/main")
  public ModelAndView searchmain(String keyword) throws Exception {

    Collection<User> userList = userDao.findByKeyword(keyword);
    Collection<Theme> themeList = publicThemeDao.findByKeyword(keyword);

    ModelAndView mv = new ModelAndView();
    mv.addObject("userList", userList);
    mv.addObject("themeList", themeList);
    mv.addObject("keyword", keyword);
    mv.addObject("pageTitle", "통합 검색 목록보기");
    mv.addObject("contentUrl", "search/Search.jsp");
    mv.setViewName("template_main");
    return mv;
  }


}
