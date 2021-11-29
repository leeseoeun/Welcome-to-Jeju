package com.welcomeToJeju.wtj.servlet.report;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.welcomeToJeju.wtj.dao.ReportDao;
import com.welcomeToJeju.wtj.dao.PublicThemeDao;
import com.welcomeToJeju.wtj.domain.ReportTheme;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.User;

@WebServlet("/report/theme")
public class ReportThemeAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ReportDao reportDao;
  PublicThemeDao publicThemeDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    reportDao = (ReportDao) 웹애플리케이션공용저장소.getAttribute("reportDao");
    publicThemeDao = (PublicThemeDao) 웹애플리케이션공용저장소.getAttribute("themeDao");
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      //
      int no = Integer.parseInt(request.getParameter("no"));
      Theme theme = publicThemeDao.findByNo(no);

      System.out.println(theme);

      ReportTheme reportTheme = new ReportTheme();

      reportTheme.setReportedTheme(theme);

      User loginUser = (User) request.getSession(true).getAttribute("loginUser");
      reportTheme.setWriter(loginUser);

      reportTheme.setContent(request.getParameter("content"));

      System.out.println(reportTheme);

      //신고당한 횟수

      request.setAttribute("theme", theme);
      request.setAttribute("reportTheme", reportTheme);

      reportDao.insertReportTheme(reportTheme);
      sqlSession.commit();

      response.setHeader("Refresh", "1;url=list");
      request.getRequestDispatcher("ReportThemeAdd.jsp").forward(request, response);

    } catch (Exception e) {
      System.out.println(e);
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }


}
