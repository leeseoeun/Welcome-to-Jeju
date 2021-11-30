package com.welcomeToJeju.wtj.web.admin;

import java.util.Collection;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class AdminUserController {

  @Autowired UserDao userDao;
  @Autowired ThemeDao themeDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @GetMapping("/admin/userlist")
  public ModelAndView list() throws Exception {
    Collection<User> userList = userDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("userList", userList);
    mv.addObject("pageTitle", "회원 목록 보기");
    mv.addObject("contentUrl", "admin/AdminUserList.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  @GetMapping("/admin/userdetail")
  public ModelAndView detail(int no) throws Exception {
    User user = userDao.findByNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("user", user);
    mv.addObject("pageTitle", "회원 상세 보기");
    mv.addObject("contentUrl", "admin/AdminUserDetail.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  @PostMapping("/admin/userupdate")
  public ModelAndView update(int no, User user) throws Exception {
    User oldUser = userDao.findByNo(no);

    user.setNo(oldUser.getNo());
    user.setEmail(oldUser.getEmail());
    user.setRegisteredDate(oldUser.getRegisteredDate());
    user.setEmoji(oldUser.getEmoji());
    user.setViewCount(oldUser.getViewCount());
    user.setActive(oldUser.getActive());
    userDao.update(user);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:userlist");

    return mv;
  }

  @GetMapping("/admin/userdelete")
  public ModelAndView delete(int no) throws Exception {
    User user = userDao.findByNo(no);

    themeDao.deleteAllLikedThemeByUserNo(user.getNo());
    userDao.deleteAllLikedUser(user.getNo());
    userDao.updateActive(user.getNo());
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:userlist");

    return mv;
  }


}
