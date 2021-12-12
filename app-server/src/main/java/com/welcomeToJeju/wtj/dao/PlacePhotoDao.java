package com.welcomeToJeju.wtj.dao;

import java.util.HashMap;
import java.util.List;
import com.welcomeToJeju.wtj.domain.PlacePhoto;

public interface PlacePhotoDao {

  void insert(HashMap<String,Object> param) throws Exception;
  void delete(String id) throws Exception;

  List<PlacePhoto> findAllByPlaceId(String id) throws Exception;


}
