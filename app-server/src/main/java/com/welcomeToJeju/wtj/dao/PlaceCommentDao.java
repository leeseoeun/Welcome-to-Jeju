package com.welcomeToJeju.wtj.dao;

import java.util.HashMap;

public interface PlaceCommentDao {

  void insert(HashMap<String,Object> param) throws Exception;
  void delete(String id) throws Exception;

}
