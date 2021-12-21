package com.welcomeToJeJu.wtj.handler;

import java.util.List;
import com.welcomeToJeJu.wtj.domain.User;

public abstract class AbstractSearchHandler implements Command {
  List<User> userList;

  public AbstractSearchHandler(List<User> userList) {
    this.userList = userList;
  }


}
