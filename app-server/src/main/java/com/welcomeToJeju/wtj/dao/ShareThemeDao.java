package com.welcomeToJeju.wtj.dao;

import java.util.List;
import com.welcomeToJeju.wtj.domain.Theme;
import com.welcomeToJeju.wtj.domain.ThemeCategory;

public interface ShareThemeDao {

  // 테마
  void insert(Theme theme) throws Exception;
  void update(Theme theme) throws Exception;
  void delete(int themeNo) throws Exception;

  ThemeCategory findCategoryByNo(int no) throws Exception;
  List<ThemeCategory> findAllCategory() throws Exception;

  // 테마 목록: 관리자
  List<Theme> findAll() throws Exception;
  List<Theme> findAllByUserNo(int userNo) throws Exception;

  // 테마 목록: 유저
  List<Theme> findAllShareTheme() throws Exception;
  List<Theme> findAllShareThemeByUserNo(int userNo) throws Exception;

  List<Theme> findAllShareThemeByPlaceId(String placeId) throws Exception;

  // 좋아하는 테마
  List<Theme> findAllLikedTheme(int userNo) throws Exception;

  // 테마 검색
  Theme findByNo(int no) throws Exception;
  Theme findByTitle(String title) throws Exception;
  List<Theme> findByKeyword(String keyword) throws Exception;

  // 순위
  void updateViewCount(int themeNo) throws Exception;

  // 메인
  List<Theme> themeRanking10() throws Exception;
  List<Theme> newTheme10() throws Exception;


}
