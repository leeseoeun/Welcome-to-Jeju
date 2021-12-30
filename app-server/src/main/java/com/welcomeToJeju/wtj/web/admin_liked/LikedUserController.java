package com.welcomeToJeju.wtj.web.admin_liked;
//package com.welcomeToJeju.wtj.web;
//
//import java.util.List;
//import javax.servlet.http.HttpSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//import com.welcomeToJeju.wtj.dao.UserDao;
//import com.welcomeToJeju.wtj.domain.User;
//
//@Controller
//public class LikedUserController {
//
//  @Autowired UserDao userDao;
//  @Autowired SqlSessionFactory sqlSessionFactory;
//
//  @GetMapping("/likeduser/add")
//  public String add(int userNo, HttpSession session, int themeNo) throws Exception {
//    userDao.insertLikedUser(userNo, ((User) session.getAttribute("loginUser")).getNo());
//    sqlSessionFactory.openSession().commit();
//
//    return "redirect:../place/list?no=" + themeNo;
//  }
//
//  @GetMapping("/likeduser/list")
//  public ModelAndView list(HttpSession session) throws Exception {
//    List<User> userList = userDao.findAllLikedUser(((User) session.getAttribute("loginUser")).getNo());
//
//    ModelAndView mv = new ModelAndView();
//    mv.addObject("userList", userList);
//    mv.addObject("pageTitle", "내가 좋아하는 유저 보기");
//    mv.addObject("contentUrl", "likedUser/LikedUserList.jsp");
//    mv.setViewName("template_main");
//
//    return mv;
//  }
//
//  @GetMapping("/likeduser/delete")
//  public String delete(int userNo, HttpSession session) throws Exception {
//    userDao.deleteLikedUser(userNo, ((User)session.getAttribute("loginUser")).getNo());
//    sqlSessionFactory.openSession().commit();
//
//    return "redirect:list";
//  }
//
//
//}
