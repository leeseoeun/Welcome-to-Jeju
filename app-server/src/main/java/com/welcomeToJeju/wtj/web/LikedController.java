package com.welcomeToJeju.wtj.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.User;

public class LikedController {

  @Autowired ThemeDao themeDao;
  @Autowired UserDao userDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  // 좋아요
  @GetMapping("/likedtheme/list")
  public ModelAndView list(HttpSession session) throws Exception {
    User user = (User) session.getAttribute("loginUser");

    List<Theme> themeList = new ArrayList<>();      // 유저 테마
    List<Theme> shareThemeList = new ArrayList<>(); // 참여 테마

    List<User> userList = userDao.findAllLikedUser(user.getNo());

    for (Theme theme : themeDao.findAllLikedTheme(user.getNo())) {
      if (theme.getIsShare() == 0) {
        themeList.add(theme);
      } else if (theme.getIsShare() == 1) {
        shareThemeList.add(theme);
      }
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("themeList", themeList);
    mv.addObject("shareThemeList", shareThemeList);
    mv.addObject("userList", userList);
    mv.addObject("pageTitle", "좋아요 목록 보기");
    mv.addObject("contentUrl", "liked/LikedList.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  // 좋아하는 테마
  @GetMapping("/likedtheme/add")
  public String add(int themeNo, HttpSession session) throws Exception {
    themeDao.insertLikedTheme(themeNo, ((User)session.getAttribute("loginUser")).getNo());
    sqlSessionFactory.openSession().commit();

    return "redirect:../place/list?no=" + themeNo;
  }

  @GetMapping("/likedtheme/delete")
  public String likedThemedelete(int themeNo, HttpSession session) throws Exception {
    themeDao.deleteLikedTheme(themeNo, ((User)session.getAttribute("loginUser")).getNo());
    sqlSessionFactory.openSession().commit();

    return "redirect:list";
  }

  // 좋아하는 유저
  @GetMapping("/likeduser/add")
  public String add(int userNo, HttpSession session, int themeNo) throws Exception {
    userDao.insertLikedUser(userNo, ((User) session.getAttribute("loginUser")).getNo());
    sqlSessionFactory.openSession().commit();

    return "redirect:../place/list?no=" + themeNo;
  }

  @GetMapping("/likeduser/delete")
  public String likedUserDelete(int userNo, HttpSession session) throws Exception {
    userDao.deleteLikedUser(userNo, ((User)session.getAttribute("loginUser")).getNo());
    sqlSessionFactory.openSession().commit();

    return "redirect:list";
  }


}
