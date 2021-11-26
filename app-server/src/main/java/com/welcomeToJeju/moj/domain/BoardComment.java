package com.welcomeToJeju.moj.domain;

public class BoardComment {

  int no;
  String comment;

  int boardNo;
  int userNo;

  @Override
  public String toString() {
    return "BoardComment [no=" + no + ", comment=" + comment + ", boardNo=" + boardNo + ", userNo="
        + userNo + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }

  public int getUserNo() {
    return userNo;
  }

  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }


}
