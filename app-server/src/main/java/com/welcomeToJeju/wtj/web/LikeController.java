package com.welcomeToJeju.wtj.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.PublicThemeDao;
import com.welcomeToJeju.wtj.dao.ShareThemeDao;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class LikeController {

  @Autowired PublicThemeDao publicThemeDao;
  @Autowired ShareThemeDao shareThemeDao;
  @Autowired ThemeDao themeDao;
  @Autowired UserDao userDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  // 좋아요
  @GetMapping("/like/list")
  public ModelAndView list(int no) throws Exception {
    List<Theme> publicThemeList = publicThemeDao.findAllLikeTheme(no);
    List<Theme> shareThemeList = shareThemeDao.findAllLikeTheme(no);
    List<User> userList = userDao.findAllLikeUser(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("publicThemeList", publicThemeList);
    mv.addObject("shareThemeList", shareThemeList);
    mv.addObject("userList", userList);
    mv.addObject("pageTitle", "좋아요 목록 보기");
    mv.addObject("contentUrl", "like/LikeList.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  // 좋아하는 테마
  @GetMapping("/liketheme/add")
  public String likeThemeAdd(int themeNo, HttpSession session) throws Exception {
    themeDao.insertLikeTheme(themeNo, ((User)session.getAttribute("loginUser")).getNo());
    sqlSessionFactory.openSession().commit();

    return "redirect:../place/list?no=" + themeNo;
  }

  @GetMapping("/liketheme/delete")
  public String likeThemedelete(int themeNo, HttpSession session) throws Exception {
    int loginUserNo = ((User)session.getAttribute("loginUser")).getNo();

    themeDao.deleteLikeTheme(themeNo, loginUserNo);
    sqlSessionFactory.openSession().commit();

    return "redirect:../like/list?no=" + loginUserNo;
  }

  // 좋아하는 유저
  @GetMapping("/likeuser/add")
  public String likeUserAdd(int userNo, HttpSession session, int themeNo) throws Exception {
    userDao.insertLikeUser(userNo, ((User) session.getAttribute("loginUser")).getNo());
    sqlSessionFactory.openSession().commit();

    return "redirect:../place/list?no=" + themeNo;
  }

  @GetMapping("/likeuser/delete")
  public String likeUserDelete(int userNo, HttpSession session) throws Exception {
    int loginUserNo = ((User)session.getAttribute("loginUser")).getNo();

    userDao.deleteLikeUser(userNo, loginUserNo);
    sqlSessionFactory.openSession().commit();

    return "redirect:../like/list?no=" + loginUserNo;
  }


}
