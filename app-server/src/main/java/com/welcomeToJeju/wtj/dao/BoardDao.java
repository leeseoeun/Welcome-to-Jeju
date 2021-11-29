package com.welcomeToJeju.wtj.dao;

import java.util.List;
import com.welcomeToJeju.wtj.domain.Board;

public interface BoardDao {

  void insert(Board board) throws Exception;
  List<Board> findAll() throws Exception;


}
