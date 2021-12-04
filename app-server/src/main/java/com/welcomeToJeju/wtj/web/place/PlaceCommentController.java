package com.welcomeToJeju.wtj.web.place;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.welcomeToJeju.wtj.dao.PlaceCommentDao;
import com.welcomeToJeju.wtj.domain.PlaceComment;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class PlaceCommentController {   //

  @Autowired PlaceCommentDao placeCommentDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @PostMapping("/comment/add")
  public ModelAndView add(PlaceComment comment,
      HttpSession session, /* Place place */String id) throws Exception {
    User user = (User) session.getAttribute("loginUser");

    HashMap<String,Object> param = new HashMap<>();
    param.put("comment", comment);
    param.put("userNo", user.getNo());
    //    param.put("placeId", place.getId());
    param.put("placeId", id);

    placeCommentDao.insert(param);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../place/detail");
    return mv;
  }


}
