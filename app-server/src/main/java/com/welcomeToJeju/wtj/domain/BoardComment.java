package com.welcomeToJeju.wtj.domain;

import java.sql.Date;

public class BoardComment {

  private int no;
  private Board board;
  private User writer;
  private String content;
  private Date registeredDate;

  @Override
  public String toString() {
    return "BoardComment [no=" + no + ", board=" + board + ", writer=" + writer + ", comment="
        + content + ", registeredDate=" + registeredDate + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public User getWriter() {
    return writer;
  }

  public void setWriter(User writer) {
    this.writer = writer;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }


}
