package com.welcomeToJeJu.wtj.handler;

import java.util.List;
import com.welcomeToJeJu.wtj.domain.Theme;
import com.welcomeToJeJu.wtj.domain.User;

public abstract class AbstractMyThemeHandler implements Command {

  List<User> userList;

  public AbstractMyThemeHandler(List<User> userList) {
    this.userList = userList;
  }

  protected Theme findByTitle(String title) {
    for(User user : userList) {
      for (Theme theme : user.getThemeList()) {
        if (theme.getTitle().equals(title))
          return theme;
      }
    }

    return null;
  }


}
