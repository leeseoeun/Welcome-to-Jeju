package com.welcomeToJeju.wtj.web.place;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.PlaceDao;
import com.welcomeToJeju.wtj.domain.Place;

@Controller
public class PlaceController {

  @Autowired PlaceDao placeDao;

  @Autowired SqlSessionFactory sqlSessionFactory;

  @GetMapping("/place/list")
  public ModelAndView place() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.addObject("contentUrl", "place/kakao_map.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  @PostMapping("/place/addform")
  public ModelAndView addform(Place place) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("place", place);
    mv.addObject("pageTitle", "장소 등록하기");
    mv.addObject("contentUrl", "place/PlaceAddForm.jsp");
    mv.setViewName("template_main");
    return mv;
  }

  @PostMapping("/place/add")
  public ModelAndView add(Place place) throws Exception{
    placeDao.insert(place);

    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");

    return mv;
  }


}
