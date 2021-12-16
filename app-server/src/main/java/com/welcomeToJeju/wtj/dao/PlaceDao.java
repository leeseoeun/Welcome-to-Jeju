package com.welcomeToJeju.wtj.dao;

import java.util.HashMap;
import java.util.List;
import com.welcomeToJeju.wtj.domain.Place;

public interface PlaceDao { //

  void insert(Place place) throws Exception;
  void insertPlaceUserTheme(HashMap<String,Object> param) throws Exception;

  void deletePlaceUserTheme(HashMap<String,Object> param) throws Exception;

  Place findById(String id) throws Exception;
  List<Place> findAllByThemeNo(int themeNo) throws Exception;

  List<Place> placeRanking10() throws Exception;


}
