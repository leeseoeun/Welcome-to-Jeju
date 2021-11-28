package com.welcomeToJeju.wtj.dao;

import java.util.List;
import com.welcomeToJeju.wtj.domain.ReportTheme;
import com.welcomeToJeju.wtj.domain.ReportUser;

public interface ReportDao {

  void insertReportTheme(ReportTheme reportTheme) throws Exception;
  List<ReportTheme> findAllReportTheme() throws Exception;
  List<ReportTheme> reportThemeFindByUserNo(int themeNo) throws Exception;

  void insertReportUser(ReportUser reportUser) throws Exception;
  List<ReportUser> findAllReportUser() throws Exception;
  List<ReportUser> reportUserFindByUserNo(int userNo) throws Exception;


}
