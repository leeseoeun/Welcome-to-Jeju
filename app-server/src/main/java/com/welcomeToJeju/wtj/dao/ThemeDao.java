package com.welcomeToJeju.wtj.dao;

import java.util.List;
import com.welcomeToJeju.wtj.domain.Theme;

public interface ThemeDao {

  // 테마 검색
  Theme findByNo(int no) throws Exception;
  Theme findByTitle(String title) throws Exception;
  List<Theme> findByKeyword(String keyword) throws Exception;

  // 좋아하는 테마
  void insertLikeTheme(int themeNo, int userNo) throws Exception;
  void deleteLikeTheme(int themeNo, int userNo) throws Exception;
  void deleteAllLikeThemeByThemeNo(int themeNo) throws Exception;
  void deleteAllLikeThemeByUserNo(int userNo) throws Exception;


}
