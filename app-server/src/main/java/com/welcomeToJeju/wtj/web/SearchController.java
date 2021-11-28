package com.welcomeToJeju.wtj.web;

import java.util.Collection;
import javax.servlet.ServletContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class SearchController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired UserDao userDao;
  @Autowired ServletContext sc;
  @Autowired ThemeDao themeDao;

  @GetMapping("/search/hashtag")
  public ModelAndView searchHashtag(String keyword) throws Exception {

    Collection<Theme> themeList = themeDao.findByHashtag(keyword);

    ModelAndView mv = new ModelAndView();
    mv.addObject("themeList", themeList);
    mv.addObject("keyword", keyword);
    mv.addObject("pageTitle", "해시태그 검색 목록보기");
    mv.addObject("contentUrl", "search/SearchHashtag.jsp");
    mv.setViewName("template_main");
    return mv;
  }

  @GetMapping("/search/theme")
  public ModelAndView searchTheme(String keyword) throws Exception {

    Collection<Theme> themeList = themeDao.findByKeyword(keyword);

    ModelAndView mv = new ModelAndView();
    mv.addObject("themeList", themeList);
    mv.addObject("keyword", keyword);
    mv.addObject("pageTitle", "테마 검색 목록보기");
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
    mv.addObject("pageTitle", "유저 검색 목록보기");
    mv.addObject("contentUrl", "search/SearchUser.jsp");
    mv.setViewName("template_main");
    return mv;

  }

  @GetMapping("/search/all")
  public ModelAndView searchAll(String option, String keyword) throws Exception {

    Collection<User> userList = userDao.findByKeyword(keyword);
    Collection<Theme> themeList = themeDao.findByKeyword(keyword);
    Collection<Theme> hashtagList = themeDao.findByHashtag(keyword);

    ModelAndView mv = new ModelAndView();
    mv.addObject("userList", userList);
    mv.addObject("themeList", themeList);
    mv.addObject("hashtagList", hashtagList);
    mv.addObject("keyword", keyword);
    mv.addObject("pageTitle", "검색 목록보기");

    if (option.equals("all")) {
      mv.addObject("contentUrl", "search/Search.jsp");

    } else if (option.equals("theme")) {
      mv.addObject("contentUrl", "search/SearchTheme.jsp");

    }  else if (option.equals("hashtag")) {
      mv.addObject("contentUrl", "search/SearchHashtag.jsp");

    } else {
      mv.addObject("contentUrl", "search/SearchUser.jsp");

    }

    mv.setViewName("template_main");
    return mv;

  }

  // 메서드명, url 경로명 상의하기
  @GetMapping("/search/sidebar")
  public ModelAndView searchSidebar(String keyword) throws Exception {

    Collection<User> userList = userDao.findByKeyword(keyword);
    Collection<Theme> themeList = themeDao.findByKeyword(keyword);
    Collection<Theme> hashtagList = themeDao.findByHashtag(keyword);

    ModelAndView mv = new ModelAndView();
    mv.addObject("userList", userList);
    mv.addObject("themeList", themeList);
    mv.addObject("hashtagList", hashtagList);
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
    Collection<Theme> themeList = themeDao.findByKeyword(keyword);
    Collection<Theme> hashtagList = themeDao.findByHashtag(keyword);

    ModelAndView mv = new ModelAndView();
    mv.addObject("userList", userList);
    mv.addObject("themeList", themeList);
    mv.addObject("hashtagList", hashtagList);
    mv.addObject("keyword", keyword);
    mv.addObject("pageTitle", "통합 검색 목록보기");
    mv.addObject("contentUrl", "search/Search.jsp");
    mv.setViewName("template_main");
    return mv;

  }

}


