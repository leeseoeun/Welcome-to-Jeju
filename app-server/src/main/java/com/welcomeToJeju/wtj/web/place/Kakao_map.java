package com.welcomeToJeju.wtj.web.place;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.PlaceDao;
import com.welcomeToJeju.wtj.domain.Place;

@Controller
public class Kakao_map {

  @Autowired PlaceDao placeDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @GetMapping("/places/search")
  public ModelAndView place() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.addObject("contentUrl", "place/kakao_map.jsp");
    mv.setViewName("template_main");

    return mv;
  }

  @GetMapping("/places/add")
  public String add(Place place) throws Exception{

    System.out.println(place);

    placeDao.insert(place);
    sqlSessionFactory.openSession().commit();

    return "redirect:../home";
  }


}
