package com.welcomeToJeju.moj.dao;

import java.util.HashMap;
import java.util.List;
import com.welcomeToJeju.moj.domain.Theme;
import com.welcomeToJeju.moj.domain.ThemeCategory;

public interface ThemeDao {

  // 테마
  void insert(Theme theme) throws Exception;
  void insertHashtag(int themeNo, String hashtag) throws Exception;

  void update(Theme theme) throws Exception;

  void delete(int themeNo) throws Exception;
  void deleteHashtag(int themeNo) throws Exception;

  List<ThemeCategory> findAllCategory() throws Exception;
  ThemeCategory findCategoryByNo(int no) throws Exception;

  void deletePlaceUserTheme(int themeNo) throws Exception;  // 회의하기

  // 테마 목록
  List<Theme> findAll() throws Exception;
  List<Theme> findAllPublicTheme() throws Exception;
  List<Theme> findAllPublicThemeByUserNo(int userNo) throws Exception;  // 회의하기
  List<Theme> findByUserNo(int userNo) throws Exception;    // 회의하기
  List<Theme> findAllByPlaceId(String placeId) throws Exception;

  // 테마 검색
  Theme findByNo(int no) throws Exception;
  Theme findByTitle(String title) throws Exception;
  List<Theme> findByKeyword(String keyword) throws Exception;
  List<Theme> findByHashtag(String hashtag) throws Exception;

  // 좋아하는 테마
  void insertLikedTheme(int themeNo, int userNo) throws Exception;
  void deleteLikedTheme(int themeNo, int userNo) throws Exception;
  void deleteAllLikedThemeByThemeNo(int themeNo) throws Exception;
  void deleteAllLikedThemeByUserNo(int userNo) throws Exception;
  List<Theme> findAllLikedTheme(int userNo) throws Exception;

  // 순위
  void updateViewCount(int themeNo) throws Exception;

  // 신고
  void updateReportedCount(HashMap<String,Object> params) throws Exception;
  List<Theme> findAllReportedTheme() throws Exception;

  // 메인
  List<Theme> themeRanking10() throws Exception;
  List<Theme> newTheme10() throws Exception;


}
