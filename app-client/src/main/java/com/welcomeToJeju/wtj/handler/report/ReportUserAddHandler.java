package com.welcomeToJeju.wtj.handler.report;

import java.sql.Date;
import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import com.welcomeToJeju.util.Prompt;
import com.welcomeToJeju.wtj.dao.ReportDao;
import com.welcomeToJeju.wtj.dao.UserDao;
import com.welcomeToJeju.wtj.domain.ReportStatus;
import com.welcomeToJeju.wtj.domain.ReportUser;
import com.welcomeToJeju.wtj.domain.User;
import com.welcomeToJeju.wtj.handler.Command;
import com.welcomeToJeju.wtj.handler.CommandRequest;
import com.welcomeToJeju.wtj.handler.user.AuthLoginHandler;

public class ReportUserAddHandler implements Command {

  ReportDao reportDao;
  UserDao userDao;
  SqlSession sqlSession;
  public ReportUserAddHandler(ReportDao reportDao,UserDao userDao,SqlSession sqlSession) {
    this.reportDao = reportDao;
    this.userDao = userDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[유저 신고하기]");

    ReportUser reportUser = new ReportUser();

    String userNickName = Prompt.inputString("신고할 유저 닉네임 >");
    User reportedUser = userDao.findByNickname(userNickName);

    if (reportedUser == null) {
      System.out.println("등록된 유저 없음!");
      return;
    }

    if(userNickName.equals(AuthLoginHandler.getLoginUser().getNickname())) {
      System.out.println("본인은 신고 불가!");
      return;
    }

    reportUser.setReportedUser(reportedUser);

    System.out.println();
    ReportStatus reportStatus = new ReportStatus();
    reportStatus.setNo(100);

    String content = Prompt.inputString("신고 사유 > ");
    reportUser.setContent(content);
    reportUser.setRegisteredDate(new Date(System.currentTimeMillis()));
    reportUser.setWriter(AuthLoginHandler.getLoginUser());
    reportUser.setStatus(reportStatus);

    reportDao.insertReportUser(reportUser);
    int count = reportedUser.getReportedCount() + 1;
    HashMap<String,Object> params = new HashMap<>();
    params.put("userNo", reportedUser.getNo());
    params.put("reportedCnt", count);
    userDao.updateReportedCount(params);
    sqlSession.commit();
    System.out.println("유저 신고 완료!");

  }



}