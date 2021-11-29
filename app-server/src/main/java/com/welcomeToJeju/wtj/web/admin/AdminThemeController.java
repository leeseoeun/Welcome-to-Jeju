package com.welcomeToJeju.wtj.web.admin;

import java.util.Collection;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.PlaceDao;
import com.welcomeToJeju.wtj.dao.PublicThemeDao;
import com.welcomeToJeju.wtj.domain.Place;
import com.welcomeToJeju.wtj.domain.Theme;

@Controller
public class AdminThemeController {

  @Autowired PublicThemeDao publicThemeDao;
  @Autowired PlaceDao placeDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @GetMapping("/admin/themelist")   //
  public ModelAndView list() throws Exception {
    Collection<Theme> themeList = publicThemeDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("themeList", themeList);
    mv.addObject("pageTitle", "전체 테마 보기");
    mv.addObject("contentUrl", "admin/AdminThemeList.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  @GetMapping("/admin/themedetail")
  public ModelAndView detail(int no) throws Exception {
    Theme theme = publicThemeDao.findByNo(no);
    Collection<Place> placeList = placeDao.findAllByThemeNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("theme", theme);
    mv.addObject("placeList", placeList);
    mv.addObject("pageTitle", "테마 상세 보기");
    mv.addObject("contentUrl","admin/AdminThemeDetail.jsp");
    //mv.addObject("contentUrl","place/PlaceList.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  @GetMapping("/admin/themedelete")
  public ModelAndView delete(int no) throws Exception {
    Theme theme = publicThemeDao.findByNo(no);

    publicThemeDao.deleteAllLikedThemeByThemeNo(theme.getNo());
    publicThemeDao.deleteHashtag(theme.getNo());
    publicThemeDao.deletePlaceUserTheme(theme.getNo());
    publicThemeDao.delete(theme.getNo());
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:themelist");

    return mv;
  }


}
