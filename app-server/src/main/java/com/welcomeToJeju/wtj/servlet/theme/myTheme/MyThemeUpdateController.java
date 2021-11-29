package com.welcomeToJeju.wtj.servlet.theme.myTheme;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.welcomeToJeju.wtj.dao.PublicThemeDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.ThemeCategory;

@WebServlet("/mytheme/update")
public class MyThemeUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  PublicThemeDao publicThemeDao;
  UserDao userDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    publicThemeDao = (PublicThemeDao) 웹애플리케이션공용저장소.getAttribute("themeDao");
    userDao = (UserDao) 웹애플리케이션공용저장소.getAttribute("userDao");
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    try {
      int no = Integer.valueOf(request.getParameter("no"));

      Theme theme = publicThemeDao.findByNo(no);
      theme.setTitle(request.getParameter("title"));

      System.out.println(theme);
      ThemeCategory category = publicThemeDao.findCategoryByNo(
          Integer.valueOf(request.getParameter("category")));
      // 카테고리
      theme.setCategory(category);
      theme.setIsPublic(theme.getIsPublic());
      theme.setViewCount(theme.getViewCount());
      // 해시태그
      publicThemeDao.deleteHashtag(theme.getNo());
      sqlSession.commit();

      ArrayList<String> hashtagList = new ArrayList<>();
      theme.setHashtags(hashtagList);
      theme.getHashtags().add(request.getParameter("hashtags"));
      publicThemeDao.update(theme);
      for (String hashtag : theme.getHashtags()) {
        publicThemeDao.insertHashtag(theme.getNo(), hashtag);
      }
      sqlSession.commit();

      response.sendRedirect("list");
    } catch (Exception e) {
      request.setAttribute("error", e);

      // 오류가 발생하면 오류내용을 출력할 뷰를 호출한다.
      request.getRequestDispatcher("/Error.jsp").forward(request, response);

    }
  }


}
