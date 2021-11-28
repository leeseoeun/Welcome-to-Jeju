package com.welcomeToJeju.wtj.dao;

import java.util.HashMap;

public interface PlaceCommentDao {

  void insertComment(HashMap<String,Object> param) throws Exception;
  void deleteComment(String id) throws Exception;

}
