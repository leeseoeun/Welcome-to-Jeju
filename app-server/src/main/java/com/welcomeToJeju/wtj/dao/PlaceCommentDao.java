package com.welcomeToJeju.wtj.dao;

import java.util.HashMap;
import java.util.List;
import com.welcomeToJeju.wtj.domain.PlaceComment;

public interface PlaceCommentDao {

  void insert(HashMap<String,Object> param) throws Exception;
  void delete(String id) throws Exception;

  List<PlaceComment> findAllByPlaceId(String id) throws Exception;


}
