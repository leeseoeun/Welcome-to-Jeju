package com.welcomeToJeju.wtj.servlet.search;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.welcomeToJeju.wtj.dao.PublicThemeDao;
import com.welcomeToJeju.wtj.domain.Theme;

@WebServlet("/search/theme")
public class SearchThemeController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  PublicThemeDao publicThemeDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    publicThemeDao = (PublicThemeDao) 웹애플리케이션공용저장소.getAttribute("themeDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {

    String keyword = "카페";

    // request.getParameter("keyword");

    try {
      Collection<Theme> themeList = publicThemeDao.findByKeyword(keyword);

      request.setAttribute("themeList", themeList);
      request.setAttribute("keyword", keyword);
      request.setAttribute("pageTitle", "테마 검색 목록보기");
      request.setAttribute("contentUrl", "/search/SearchTheme.jsp");

      request.getRequestDispatcher("/template_main.jsp").forward(request, response);


    } catch (Exception e){
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }

  //  @Override
  //  public void execute(CommandRequest request) throws Exception {
  //    System.out.println("[유저 검색하기]");
  //
  //    while (true) {
  //      String input = Prompt.inputString("닉네임(취소 : 엔터) > ");
  //
  //      if(input.equals("") || input.length() == 0) {
  //        System.out.println("유저 검색하기 취소!");
  //        return;
  //      }
  //
  //      User user = userDao.findByNickname(input);
  //
  //      if(user == null) {
  //        System.out.println("유저 없음!");
  //        continue;
  //      }
  //
  //      // 조회수 +1
  //      int viewCount = user.getViewCount();
  //      HashMap<String,Object> params = new HashMap<>();
  //      params.put("userNo", user.getNo());
  //      params.put("viewCnt", viewCount + 1);
  //      userDao.updateViewCount(params);
  //      sqlSession.commit();
  //
  //      System.out.printf("[%s] 검색 결과\n", user.getNickname());
  //      printList(user);
  //
  //      return;
  //    }
  //  }
  //
  //  private void printList(User user) throws Exception {
  //    Collection<Theme> themeList = themeDao.findByUserNo(user.getNo());
  //
  //    int no = 1;
  //    for(Theme theme : themeList) {
  //      System.out.printf("<%d> %s\n", no++, theme.getTitle());
  //    }
  //  }


}
