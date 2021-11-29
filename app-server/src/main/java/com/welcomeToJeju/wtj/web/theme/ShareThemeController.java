package com.welcomeToJeju.wtj.web.theme;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.ShareThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.ThemeCategory;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class ShareThemeController {

  @Autowired ShareThemeDao shareThemeDao;
  @Autowired UserDao userDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @GetMapping("/sharetheme/addform")
  public ModelAndView addform(HttpSession session) {
    User user = (User) session.getAttribute("loginUser");
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "참여 테마 만들기");
    mv.addObject("contentUrl", "theme/shareTheme/ShareThemeAddForm.jsp");
    mv.setViewName("template_main");
    return mv;
  }

  @PostMapping("/sharetheme/add")
  public String add(HttpSession session, 
      String title,
      String emoji,
      String category,
      String hashtags) throws Exception {

    User user = (User) session.getAttribute("loginUser");

    Theme theme = new Theme();
    theme.setTitle(title);
    theme.setEmoji(emoji);
    theme.setOwner(user);
    String[] hashtagArr = hashtags.split("#");

    ThemeCategory c = shareThemeDao.findCategoryByNo(Integer.parseInt(category));
    theme.setCategory(c);
    theme.setIsShare(1);
    theme.setIsPublic(1);

    shareThemeDao.insert(theme);
    for (String hashtag : hashtagArr) {
      if(hashtag.length()==0) continue;
      shareThemeDao.insertHashtag(theme.getNo(), hashtag);
    }
    sqlSessionFactory.openSession().commit();
    return "redirect:list?no=" + user.getNo();
  }

  @GetMapping("/sharetheme/list")
  public ModelAndView list(int no) throws Exception {
    Collection<Theme> themeList = shareThemeDao.findAllByUserNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("themeList", themeList);
    mv.addObject("pageTitle", "참여 테마 목록 보기");
    mv.addObject("contentUrl", "theme/shareTheme/ShareThemeList.jsp");
    mv.setViewName("template_main");
    return mv;
  }

  // 테스트!!
  @PostMapping("/sharetheme/update")
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
  @GetMapping("/sharetheme/delete")
  public ModelAndView delete(HttpSession session, int no) throws Exception {
    User user = (User) session.getAttribute("loginUser");

    shareThemeDao.delete(no);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list?no=" + user.getNo());
    return mv;
  }


}
