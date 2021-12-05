package com.welcomeToJeju.wtj.dao;

import java.util.List;
import com.welcomeToJeju.wtj.domain.BoardComment;

public interface BoardCommentDao {

  void insert(BoardComment boardComment) throws Exception;
  void delete(int no) throws Exception;

  List<BoardComment> findAllByBoardNo(int no) throws Exception;

  BoardComment findByNo(int no) throws Exception;

}
