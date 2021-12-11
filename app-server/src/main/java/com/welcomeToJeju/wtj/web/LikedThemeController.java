package com.welcomeToJeju.wtj.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class LikedThemeController {

  @Autowired ThemeDao themeDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @GetMapping("/likedtheme/add")
  public String add(int themeNo, HttpSession session) throws Exception {
    themeDao.insertLikedTheme(themeNo, ((User)session.getAttribute("loginUser")).getNo());
    sqlSessionFactory.openSession().commit();

    return "redirect:../place/list?no=" + themeNo;
  }

  @GetMapping("/likedtheme/list")
  public ModelAndView list(HttpSession session) throws Exception {
    List<Theme> themeList = new ArrayList<>();
    List<Theme> shareThemeList = new ArrayList<>();

    for (Theme t : themeDao.findAllLikedTheme(((User) session.getAttribute("loginUser")).getNo())) {
      if (t.getIsShare() == 0) {
        themeList.add(t);
      } else if (t.getIsShare() == 1) {
        shareThemeList.add(t);
      }
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("themeList", themeList);
    mv.addObject("shareThemeList", shareThemeList);
    mv.addObject("pageTitle", "내가 좋아하는 테마 보기");
    mv.addObject("contentUrl", "likedTheme/LikedThemeList.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  @GetMapping("/likedtheme/delete")
  public String delete(int themeNo, HttpSession session) throws Exception {
    themeDao.deleteLikedTheme(themeNo, ((User)session.getAttribute("loginUser")).getNo());
    sqlSessionFactory.openSession().commit();

    return "redirect:list";
  }


}
