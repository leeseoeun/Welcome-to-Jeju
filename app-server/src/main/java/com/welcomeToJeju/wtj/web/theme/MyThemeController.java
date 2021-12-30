package com.welcomeToJeju.wtj.web.theme;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.PublicThemeDao;
import com.welcomeToJeju.wtj.dao.ThemeDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.ThemeCategory;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class MyThemeController {

  @Autowired ThemeDao themeDao;
  @Autowired PublicThemeDao publicThemeDao;
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
      String emoji) throws Exception {

    // 로그인한 유저 -> 만든이
    User user = (User) session.getAttribute("loginUser");

    Theme theme = new Theme();
    theme.setTitle(title);
    theme.setOwner(user);

    // 카테고리 넘버 -> 카테고리 찾기
    ThemeCategory themeCategory = publicThemeDao.findCategoryByNo(Integer.parseInt(category));
    theme.setCategory(themeCategory);

    theme.setIsPublic(Integer.parseInt(isPublic));
    theme.setEmoji(emoji);
    publicThemeDao.insert(theme);
    sqlSessionFactory.openSession().commit();

    return "redirect:list?no=" + user.getNo();
  }

  @GetMapping("/mytheme/list")
  public ModelAndView list(int no) throws Exception {

    List<Theme> publicThemeList = new ArrayList<>();    // 공개 테마
    List<Theme> privateThemeList = new ArrayList<>();   // 비공개 테마

    for (Theme theme : publicThemeDao.findAllByUserNo(no)) {
      if (theme.getIsPublic() == 1) {
        publicThemeList.add(theme);
      } else if (theme.getIsPublic() == 0) {
        privateThemeList.add(theme);
      } 
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("publicThemeList", publicThemeList);
    mv.addObject("privateThemeList", privateThemeList);
    mv.addObject("pageTitle", "나의 테마 목록 보기");
    mv.addObject("contentUrl", "theme/myTheme/MyThemeList.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  // 테스트!!
  @PostMapping("/mytheme/update")
  public ModelAndView update(Theme theme,
      String category,
      String isPublic) throws Exception {

    //    Theme oldTheme = publicThemeDao.findByNo(theme.getNo());
    //    theme.setOwner(oldTheme.getOwner());

    ThemeCategory themeCategory = publicThemeDao.findCategoryByNo(Integer.parseInt(category));
    theme.setCategory(themeCategory);

    theme.setIsPublic(Integer.parseInt(isPublic));
    publicThemeDao.update(theme);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:detail?no=" + theme.getNo());

    return mv;
  }

  // 테스트!!
  @GetMapping("/mytheme/delete")
  public ModelAndView delete(HttpSession session, int no) throws Exception {
    User user = (User) session.getAttribute("loginUser");

    themeDao.deleteAllLikeThemeByThemeNo(no);
    //    themeDao.deletePlaceUserTheme(no);
    publicThemeDao.delete(no);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list?no=" + user.getNo());
    return mv;
  }


}
