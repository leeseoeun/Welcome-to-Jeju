package com.welcomeToJeJu.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.welcomeToJeJu.util.Prompt;
import com.welcomeToJeJu.wtj.handler.AuthLoginHandler;

// 역할
// - 다른 메뉴를 포함하는 컨테이너 역할을 수행한다.
// 
public class MenuGroup extends Menu {

  static Stack<Menu> breadCrumb = new Stack<>();

  ArrayList<Menu> childs = new ArrayList<>();

  boolean disablePrevMenu;
  String prevMenuTitle = "이전 메뉴";

  public MenuGroup(String title) {
    super(title);
  }

  public MenuGroup(String title, int accessScope) {
    super(title, accessScope);
  }

  public MenuGroup(String title, boolean disablePrevMenu) {
    super(title);
    this.disablePrevMenu = disablePrevMenu;
  }

  public void setPrevMenuTitle(String prevMenuTitle) {
    this.prevMenuTitle = prevMenuTitle;
  }

  public void add(Menu child) {
    childs.add(child);
  }

  public Menu remove(Menu child) {
    if(childs.remove(child)) {
      return child;
    }
    return null;
  }

  @Override
  public void execute() {
    breadCrumb.push(this);

    while (true) {
      printBreadCrumbMenuTitle();
      List<Menu> menuList = getMenuList();
      printMenuList(menuList);

      try {
        int menuNo = Prompt.inputInt("선택 > ");

        if (menuNo < 0 || menuNo > childs.size()) {
          System.out.println("무효한 메뉴 번호!");
          continue;
        }

        if (menuNo == 0 && !disablePrevMenu) {
          breadCrumb.pop();
          return;
        }

        menuList.get(menuNo - 1).execute();

      } catch (Exception e) {
        System.out.println("------------------------------------------");
        System.out.printf("오류 발생! %s\n", e.getClass().getName());
        System.out.println("------------------------------------------");
      }

    }
  }

  public String getBreadCrumb() {
    String path = "";

    for(Menu menu : breadCrumb) {
      if(path.length() > 0) {
        path += " / ";
      }

      path += menu.title;
    }

    return path;
  }

  private void printBreadCrumbMenuTitle() {
    System.out.printf("\n[%s]\n", getBreadCrumb());
  }

  private List<Menu> getMenuList() {
    List<Menu> menuList = new ArrayList<>();

    for(Menu menu : childs) {
      if((menu.accessScope & AuthLoginHandler.getUserAccessLevel()) > 0) {
        menuList.add(menu);
      }
    }

    return menuList;
  }

  private void printMenuList(List<Menu> menuList) {
    for (int i = 0; i < menuList.size(); i++) {
      System.out.printf("%d. %s\n", i + 1, menuList.get(i).title);
    }

    if (!disablePrevMenu) {
      System.out.printf("0. %s\n", this.prevMenuTitle);
    }
  }


}
