package com.welcomeToJeju.wtj.dao;

import java.util.List;
import com.welcomeToJeju.wtj.domain.Theme;

public interface ThemeDao {

  // 테마 검색
  Theme findByNo(int no) throws Exception;
  Theme findByTitle(String title) throws Exception;
  List<Theme> findByKeyword(String keyword) throws Exception;

  // 좋아하는 테마
  void insertLikedTheme(int themeNo, int userNo) throws Exception;
  void deleteLikedTheme(int themeNo, int userNo) throws Exception;
  void deleteAllLikedThemeByThemeNo(int themeNo) throws Exception;
  void deleteAllLikedThemeByUserNo(int userNo) throws Exception;
  List<Theme> findAllLikedTheme(int userNo) throws Exception;

}
