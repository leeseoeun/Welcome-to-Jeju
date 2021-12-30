package com.welcomeToJeju.wtj.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.welcomeToJeju.wtj.domain.User;

public interface UserDao {

  // 유저
  void insert(User user) throws Exception;
  void update(User user) throws Exception;
  void delete(int userNo) throws Exception;

  // 로그인
  User findByEmailAndPassword(@Param("email") String email, @Param("password") String password) throws Exception;
  // 탈퇴
  void updateActive(int userNo) throws Exception;

  // 유저 목록
  List<User> findAll() throws Exception;

  // 유저 검색
  User findByNo(int userNo) throws Exception;
  User findByEmail(String email) throws Exception;  // 중복 체크
  User findByNickname(String nickname) throws Exception;
  List<User> findByKeyword(String keyword) throws Exception;

  // 좋아하는 유저
  void insertLikeUser(@Param("likeUserNo") int likedUserNo, @Param("loginUserNo") int loginUserNo) throws Exception;
  void deleteLikeUser(@Param("likeUserNo") int likedUserNo, @Param("loginUserNo") int loginUserNo) throws Exception;
  void deleteAllLikeUser(int userNo) throws Exception;
  List<User> findAllLikeUser(int loginUserNo) throws Exception;

  // 순위
  void updateViewCount(int userNo) throws Exception;

  // 메인
  List<User> userRanking10() throws Exception;


}
