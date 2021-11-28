package com.welcomeToJeju.wtj.domain;

import java.sql.Date;

public class BoardComment {

  int no;
  String comment;
  private Date registeredDate;

  int boardNo;
  int userNo;   // 작성자

  @Override
  public String toString() {
    return "BoardComment [no=" + no + ", comment=" + comment + ", registeredDate=" + registeredDate
        + ", boardNo=" + boardNo + ", userNo=" + userNo + "]";
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

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
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
