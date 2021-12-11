package com.welcomeToJeju.wtj.web.user;

import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.User;

@Controller
public class NaverLoginController {

  /* NaverLoginBO */
  @Autowired
  private NaverLoginBO naverLoginBO;
  private String apiResult = null;

  @Autowired(required = false)
  User user;

  @Autowired
  UserDao userDao;

  @Autowired 
  SqlSessionFactory sqlSessionFactory;

  @Autowired
  private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
    this.naverLoginBO = naverLoginBO;
  }

  // 로그인 첫 화면 요청 메소드
  @RequestMapping(value = "/auth/loginform", method = { RequestMethod.GET, RequestMethod.POST })
  public ModelAndView login(Model model, HttpSession session) {

    /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
    String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

    model.addAttribute("url", naverAuthUrl);

    /* 생성한 인증 URL을 View로 전달 */
    ModelAndView mv = new ModelAndView();
    mv.setViewName("template_main");
    mv.addObject("contentUrl", "user/AuthLoginForm.jsp");

    return mv;
  }

  // 네이버 로그인 성공시 callback호출 메소드
  @RequestMapping(value = "/auth/callback.do", method = { RequestMethod.GET, RequestMethod.POST })
  public ModelAndView callback(Model model, @RequestParam String code, @RequestParam String state,
      HttpSession session) throws Exception {

    OAuth2AccessToken oauthToken;
    oauthToken = naverLoginBO.getAccessToken(session, code, state);

    // 로그인 사용자 정보를 읽어온다.
    apiResult = naverLoginBO.getUserProfile(oauthToken);
    model.addAttribute("result", apiResult);

    // 네이버 로그인 성공 페이지 View 호출
    Object obj = new JSONParser().parse(apiResult);
    JSONObject jsonObj = (JSONObject) obj;

    // 데이터 파싱 - Top레벨 단계 _response 파싱
    JSONObject response_obj = (JSONObject) jsonObj.get("response");

    // response의 email 값 파싱
    String email = (String) response_obj.get("email");

    // API가 리턴한 email로 user 찾기
    user = userDao.findByEmail(email);

    // user가 null 일 때
    if (user == null) {

      User newUser = new User();

      newUser.setEmail(email);
      newUser.setNickname("Hello");
      userDao.insert(newUser);
      sqlSessionFactory.openSession().commit();

      session.setAttribute("loginUser", userDao.findByEmail(email));

      ModelAndView mv = new ModelAndView();
      mv.setViewName("redirect:../user/form");
      return mv;

    } 

    user.setActive(1);
    userDao.update(user);
    sqlSessionFactory.openSession().commit();
    session.setAttribute("loginUser", userDao.findByNo(user.getNo()));

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../home");
    return mv;
  }
}