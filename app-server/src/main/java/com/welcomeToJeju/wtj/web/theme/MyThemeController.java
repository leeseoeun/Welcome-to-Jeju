package com.welcomeToJeju.wtj.web.theme;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.PublicThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.ThemeCategory;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class MyThemeController {

  @Autowired PublicThemeDao publicThemeDao;
  @Autowired UserDao userDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @GetMapping("/mytheme/addform")
  public ModelAndView addform() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "나의 테마 만들기");
    mv.addObject("contentUrl", "theme/myTheme/MyThemeAddForm.jsp");
    mv.setViewName("template_main");
    return mv;
  }

  @PostMapping("/mytheme/add")
  public String add(HttpSession session, 
      String title, 
      String category,
      String isPublic,
      String hashtags) throws Exception {
    User user = (User) session.getAttribute("loginUser");
    Theme theme = new Theme();
    theme.setTitle(title);
    theme.setIsPublic(Integer.parseInt(isPublic));
    theme.setOwner(user);
    String[] hashtagArr = hashtags.split("#");

    ThemeCategory c = publicThemeDao.findCategoryByNo(Integer.parseInt(category));
    theme.setCategory(c);
    publicThemeDao.insert(theme);
    for (String hashtag : hashtagArr) {
      if(hashtag.length()==0) continue;
      publicThemeDao.insertHashtag(theme.getNo(), hashtag);
    }
    sqlSessionFactory.openSession().commit();
    return "redirect:list?no=" + user.getNo();
  }

  @GetMapping("/mytheme/list")
  public ModelAndView list(int no) throws Exception {
    Collection<Theme> themeList = publicThemeDao.findAllByUserNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("themeList", themeList);
    mv.addObject("pageTitle", "나의 테마 목록 보기");
    mv.addObject("contentUrl", "theme/myTheme/MyThemeList.jsp");
    mv.setViewName("template_main");
    return mv;
  }

  // 테스트!!
  @PostMapping("/mytheme/update")
  public ModelAndView update(Theme theme, int category) throws Exception {
    //    Theme oldTheme = themeDao.findByNo(theme.getNo());
    //
    //    if (oldTheme == null) {
    //      throw new Exception("..");
    //    }
    //
    //    Category c = themeDao.findCategoryByNo(category);
    //    theme.setCategory(c);
    //
    //    themeDao.update(theme);
    //    sqlSessionFactory.openSession().commit();
    //
    ModelAndView mv = new ModelAndView();
    //    mv.setViewName("redirect:detail?no=" + theme.getNo());
    return mv;
  }

  // 테스트!!
  @GetMapping("/mytheme/delete")
  public ModelAndView delete(HttpSession session, int no) throws Exception {
    User user = (User) session.getAttribute("loginUser");

    publicThemeDao.delete(no);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list?no=" + user.getNo());
    return mv;
  }


}
