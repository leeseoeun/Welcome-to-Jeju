package com.welcomeToJeju.wtj.web.user;

import javax.servlet.http.HttpSession;
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
  private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
    this.naverLoginBO = naverLoginBO;
  }

  // 로그인 첫 화면 요청 메소드
  @RequestMapping(value = "/user/naverlogin", method = { RequestMethod.GET, RequestMethod.POST })
  public String login(Model model, HttpSession session) {

    /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
    String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

    // https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
    // redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
    System.out.println("네이버:" + naverAuthUrl);

    // 네이버
    model.addAttribute("url", naverAuthUrl);

    /* 생성한 인증 URL을 View로 전달 */
    return "user/NaverLogin";
  }

  // 네이버 로그인 성공시 callback호출 메소드
  @RequestMapping(value = "/user/callback.do", method = { RequestMethod.GET, RequestMethod.POST })
  public ModelAndView callback(Model model, @RequestParam String code, @RequestParam String state,
      HttpSession session) throws Exception {
    System.out.println("여기는 callback");
    OAuth2AccessToken oauthToken;
    oauthToken = naverLoginBO.getAccessToken(session, code, state);
    // 로그인 사용자 정보를 읽어온다.
    apiResult = naverLoginBO.getUserProfile(oauthToken);
    System.out.println(naverLoginBO.getUserProfile(oauthToken).toString());
    model.addAttribute("result", apiResult);
    System.out.println("result" + apiResult);
    /* 네이버 로그인 성공 페이지 View 호출 */
    JSONParser parser = new JSONParser();
    Object obj = parser.parse(apiResult);
    JSONObject jsonObj = (JSONObject) obj;
    System.out.println(apiResult);

    // 3. 데이터 파싱
    // Top레벨 단계 _response 파싱
    JSONObject response_obj = (JSONObject) jsonObj.get("response");
    // response의 nickname값 파싱
    String userId = (String) response_obj.get("id");
    System.out.println(userId);

    // DB저장
    user = userDao.findByEmail(userId);

    if (user == null) {

      User newUser = new User();
      newUser.setEmail(userId);
      userDao.insert(newUser);

      ModelAndView mv = new ModelAndView();
      mv.addObject("email", userId);
      mv.addObject("contentUrl", "user/UserAddForm2.jsp");
      mv.setViewName("template_main");
      return mv;
    }

    // 4.파싱 닉네임 세션으로 저장
    session.setAttribute("loginUser", user); // 세션 생성
    // return "redirect:/";
    //
    //
    //      UserVO vo = new UserVO();
    //      vo.setUser_snsId(snsId);
    //      vo.setUser_name(name);
    //
    //      System.out.println(name);
    //      try {
    //          vo = service.naverLogin(vo);
    //      } catch (Exception e) {
    //          // TODO Auto-generated catch block
    //          e.printStackTrace();
    //      }

    //      session.setAttribute("login",vo);
    //      return new ModelAndView("user/loginPost", "result", vo);

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../home");
    return mv;

  }

}