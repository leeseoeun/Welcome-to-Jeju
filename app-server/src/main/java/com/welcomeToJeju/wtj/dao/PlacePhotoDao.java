package com.welcomeToJeju.wtj.dao;

import java.util.HashMap;
import java.util.List;
import com.welcomeToJeju.wtj.domain.Place;

public interface PlacePhotoDao {

  void insertPhoto(HashMap<String,Object> param) throws Exception;
  void deletePhoto(String id) throws Exception;

}
