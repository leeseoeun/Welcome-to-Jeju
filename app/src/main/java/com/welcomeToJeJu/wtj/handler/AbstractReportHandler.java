package com.welcomeToJeJu.wtj.handler;

import java.util.ArrayList;
import java.util.List;
import com.welcomeToJeJu.wtj.domain.Report;

public abstract class AbstractReportHandler implements Command {

  List<Report> boardList = new ArrayList<>();

  public AbstractReportHandler (List<Report> boardList) {
    this.boardList = boardList;
  }


}
