package com.welcomeToJeJu.wtj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.welcomeToJeJu.context.ApplicationContextListener;
import com.welcomeToJeJu.context.UserContextListener;
import com.welcomeToJeJu.menu.Menu;
import com.welcomeToJeJu.menu.MenuGroup;
import com.welcomeToJeJu.util.Prompt;
import com.welcomeToJeJu.wtj.domain.Report;
import com.welcomeToJeJu.wtj.domain.ReportTheme;
import com.welcomeToJeJu.wtj.domain.ReportUser;
import com.welcomeToJeJu.wtj.domain.Theme;
import com.welcomeToJeJu.wtj.domain.User;
import com.welcomeToJeJu.wtj.handler.AllThemeListHandler;
import com.welcomeToJeJu.wtj.handler.AuthDisplayLoginUserHandler;
import com.welcomeToJeJu.wtj.handler.AuthLoginHandler;
import com.welcomeToJeJu.wtj.handler.AuthLogoutHandler;
import com.welcomeToJeJu.wtj.handler.Command;
import com.welcomeToJeJu.wtj.handler.CommandRequest;
import com.welcomeToJeJu.wtj.handler.LikedThemeAddHandler;
import com.welcomeToJeJu.wtj.handler.LikedThemeDeleteHandler;
import com.welcomeToJeJu.wtj.handler.LikedThemeListHandler;
import com.welcomeToJeJu.wtj.handler.LikedUserAddHandler;
import com.welcomeToJeJu.wtj.handler.LikedUserDeleteHandler;
import com.welcomeToJeJu.wtj.handler.LikedUserListHandler;
import com.welcomeToJeJu.wtj.handler.MyThemeAddHandler;
import com.welcomeToJeJu.wtj.handler.MyThemeDeleteHandler;
import com.welcomeToJeJu.wtj.handler.MyThemeDetailHandler;
import com.welcomeToJeJu.wtj.handler.MyThemeListHandler;
import com.welcomeToJeJu.wtj.handler.MyThemeUpdateHandler;
import com.welcomeToJeJu.wtj.handler.PlaceAddHandler;
import com.welcomeToJeJu.wtj.handler.PlaceDeleteHandler;
import com.welcomeToJeJu.wtj.handler.PlaceListHandler;
import com.welcomeToJeJu.wtj.handler.RealTimeRankHandler;
import com.welcomeToJeJu.wtj.handler.ReportAddThemeHandler;
import com.welcomeToJeJu.wtj.handler.ReportAddUserHandler;
import com.welcomeToJeJu.wtj.handler.ReportMyListHandler;
import com.welcomeToJeJu.wtj.handler.ReportThemeProcessingHandler;
import com.welcomeToJeJu.wtj.handler.ReportUserProcessingHandler;
import com.welcomeToJeJu.wtj.handler.SearchHashtagHandler;
import com.welcomeToJeJu.wtj.handler.SearchThemeHandler;
import com.welcomeToJeJu.wtj.handler.SearchUserHandler;
import com.welcomeToJeJu.wtj.handler.UserAddHandler;
import com.welcomeToJeJu.wtj.handler.UserDeleteHandler;
import com.welcomeToJeJu.wtj.handler.UserDetailHandler;
import com.welcomeToJeJu.wtj.handler.UserEditHandler;
import com.welcomeToJeJu.wtj.handler.UserListHandler;
import com.welcomeToJeJu.wtj.handler.UserRankHandler;
import com.welcomeToJeJu.wtj.handler.UserUnregisterHandler;
import com.welcomeToJeJu.wtj.handler.UserUpdateHandler;
import com.welcomeToJeJu.wtj.listener.FileListener;
import com.welcomeToJeJu.wtj.listener.LoginListener;

public class App {
  List<User> userList = new ArrayList<>();
  List<Theme> themeList = new ArrayList<>();

  public static List<Report> reportList = new ArrayList<>();
  List<ReportTheme> reportThemeList = new ArrayList<>();
  List<ReportUser> reportUserList = new ArrayList<>();

  HashMap<String,Command> commandMap = new HashMap<>();

  List<ApplicationContextListener> listeners = new ArrayList<>();
  List<UserContextListener> userListeners = new ArrayList<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    this.listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    this.listeners.remove(listener);
  }

  public void addUserContextListener(UserContextListener userListener) {
    this.userListeners.add(userListener);
  }

  public void removeUserContextListener(UserContextListener userListener) {
    this.userListeners.remove(userListener);
  }

  class MenuItem extends Menu {
    String menuId;

    public MenuItem(String title, String menuId) {
      super(title);
      this.menuId = menuId;
    }

    public MenuItem(String title, int enableState, String menuId) {
      super(title, enableState);
      this.menuId = menuId;
    }

    @Override
    public void execute() {
      Command command = commandMap.get(menuId);
      try {
        command.execute(new CommandRequest(commandMap));
      } catch (Exception e) {
        System.out.printf("%s 명령을 실행하는 중 오류 발생!", menuId);
        e.printStackTrace();
      } 
    }
  }

  public App() {
    commandMap.put("/auth/login", new AuthLoginHandler(userList, userListeners));
    commandMap.put("/auth/logout", new AuthLogoutHandler(userListeners));
    commandMap.put("/auth/displayLoginUer", new AuthDisplayLoginUserHandler());
    commandMap.put("/theme/all", new AllThemeListHandler(userList));
    commandMap.put("/auth/unregistered", new UserUnregisterHandler(userList));
    commandMap.put("/auth/edit", new UserEditHandler());
    // 회원 탈퇴 메뉴 추가

    commandMap.put("/user/add", new UserAddHandler(userList));
    commandMap.put("/user/delete", new UserDeleteHandler(userList));
    commandMap.put("/user/detail", new UserDetailHandler(userList));
    commandMap.put("/user/list", new UserListHandler(userList));
    commandMap.put("/user/update", new UserUpdateHandler(userList));

    commandMap.put("/myTheme/add", new MyThemeAddHandler(userList,themeList));
    commandMap.put("/myTheme/delete", new MyThemeDeleteHandler(userList));
    commandMap.put("/myTheme/list", new MyThemeListHandler(userList));
    commandMap.put("/myTheme/detail", new MyThemeDetailHandler(userList));
    commandMap.put("/myTheme/update", new MyThemeUpdateHandler(userList));

    commandMap.put("/likedTheme/add", new LikedThemeAddHandler(userList));
    commandMap.put("/likedTheme/delete", new LikedThemeDeleteHandler(userList));
    commandMap.put("/likedTheme/list", new LikedThemeListHandler());

    commandMap.put("/place/add", new PlaceAddHandler());
    commandMap.put("/place/delete", new PlaceDeleteHandler());
    commandMap.put("/place/list", new PlaceListHandler());

    commandMap.put("/search/searchTheme", new SearchThemeHandler(userList, themeList));
    commandMap.put("/search/searchUser", new SearchUserHandler(userList));
    commandMap.put("/search/searchHashtag", new SearchHashtagHandler(userList, themeList));

    commandMap.put("/likedUser/add", new LikedUserAddHandler(userList));
    commandMap.put("/likedUser/list", new LikedUserListHandler(userList));
    commandMap.put("/likedUser/delete", new LikedUserDeleteHandler());

    commandMap.put("/rank/themeRank", new RealTimeRankHandler(userList));
    commandMap.put("/rank/userRank", new UserRankHandler(userList));

    commandMap.put("/report/theme", new ReportAddThemeHandler(userList,reportThemeList));
    commandMap.put("/report/user", new ReportAddUserHandler(userList,reportUserList));
    commandMap.put("/report/list", new ReportMyListHandler(reportList));
    commandMap.put("/report/themeProcess", new ReportThemeProcessingHandler(userList,reportThemeList));
    commandMap.put("/report/userProcess", new ReportUserProcessingHandler(userList,reportUserList));
  }

  public static void main(String[] args) {
    App app = new App();
    app.addApplicationContextListener(new FileListener());
    app.addUserContextListener(new LoginListener());
    app.service();
  }

  private void notifyOnApplicationStarted() {
    HashMap<String,Object> params = new HashMap<>();
    params.put("userList", userList);
    params.put("reportThemeList", reportThemeList);
    params.put("reportUserList", reportUserList);

    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(params);
    }
  }

  private void notifyOnApplicationEnded() {
    HashMap<String,Object> params = new HashMap<>();
    params.put("userList", userList);
    params.put("reportThemeList", reportThemeList);
    params.put("reportUserList", reportUserList);

    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(params);
    }
  }

  void service() {
    notifyOnApplicationStarted();
    reportList.addAll(reportThemeList);
    reportList.addAll(reportUserList);

    createMenu().execute();
    Prompt.close();
    notifyOnApplicationEnded();
  }


  Menu createMenu() {
    MenuGroup mg = new MenuGroup("메인 메뉴");
    mg.setPrevMenuTitle("종료");

    mg.add(new MenuItem("로그인", Menu.ACCESS_LOGOUT, "/auth/login"));
    mg.add(new MenuItem("회원 가입하기", Menu.ACCESS_LOGOUT, "/user/add"));
    mg.add(new MenuItem("내 정보", Menu.ACCESS_GENERAL, "/auth/displayLoginUer"));
    mg.add(new MenuItem("로그아웃", Menu.ACCESS_GENERAL, "/auth/logout"));
    mg.add(new MenuItem("전체 테마 보기", "/theme/all"));

    createUserMenu(mg);
    createMyMapMenu(mg);
    //    createPlaceMenu(mg);
    createSearchMenu(mg);
    createLikedThemeMenu(mg);
    createLikedUserMenu(mg);
    createRankMenu(mg);
    createReportMenu(mg);

    return mg;
  }


  private Menu createUserMenu(MenuGroup mg) {
    MenuGroup user = new MenuGroup("회원 관리", Menu.ACCESS_ADMIN);

    user.add(new MenuItem("회원 목록보기", Menu.ACCESS_ADMIN, "/user/list"));
    user.add(new MenuItem("회원 상세보기", Menu.ACCESS_ADMIN, "/user/detail"));
    user.add(new MenuItem("회원 수정하기", Menu.ACCESS_ADMIN, "/user/update"));
    user.add(new MenuItem("회원 삭제하기", Menu.ACCESS_ADMIN, "/user/delete"));

    mg.add(user);
    return user;
  }

  private void createMyMapMenu(MenuGroup mg) {
    MenuGroup myMap = new MenuGroup("나의 테마", Menu.ACCESS_ADMIN | Menu.ACCESS_GENERAL);

    myMap.add(new MenuItem("테마 만들기", "/myTheme/add"));
    myMap.add(new MenuItem("테마 목록보기", "/myTheme/list"));
    myMap.add(new MenuItem("테마 상세보기", "/myTheme/detail"));
    //    myMap.add(new MenuItem("테마 수정하기", "/myTheme/update"));
    myMap.add(new MenuItem("테마 삭제하기", "/myTheme/delete"));

    mg.add(myMap);
  }

  //  private void createPlaceMenu(MenuGroup mg) {
  //    MenuGroup savePlaceInTheme = new MenuGroup("테마에 장소 추가", Menu.ACCESS_ADMIN | Menu.ACCESS_GENERAL);
  //
  //    savePlaceInTheme.add(new MenuItem("장소 등록", "/place/add"));
  //    savePlaceInTheme.add(new MenuItem("장소 목록", "/place/list"));
  //    savePlaceInTheme.add(new MenuItem("장소 삭제", "/place/delete"));
  //
  //    mg.add(savePlaceInTheme);
  //  }

  private void createSearchMenu(MenuGroup mg) {
    MenuGroup search = new MenuGroup("검색하기");

    search.add(new MenuItem("테마 검색하기", "/search/searchTheme"));
    // 장소 이쁘게 출력
    search.add(new MenuItem("유저 검색하기", "/search/searchUser"));
    search.add(new MenuItem("해시태그 검색하기", "/search/searchHashtag"));

    mg.add(search);
  }

  private void createLikedThemeMenu(MenuGroup mg) {
    MenuGroup like = new MenuGroup("좋아하는 테마", Menu.ACCESS_ADMIN | Menu.ACCESS_GENERAL);

    like.add(new MenuItem("좋아요 등록하기", "/likedTheme/add"));
    like.add(new MenuItem("좋아요 목록보기", "/likedTheme/list"));
    like.add(new MenuItem("좋아요 삭제하기", "/likedTheme/delete"));

    mg.add(like);
  }

  private void createRankMenu(MenuGroup mg) {
    MenuGroup rank = new MenuGroup("순위보기");

    rank.add(new MenuItem("테마 순위보기", "/rank/themeRank"));   // 테마 검색 시 조회수 증가
    rank.add(new MenuItem("유저 순위보기", "/rank/userRank"));    // 유저 검색 시 조회수 증가

    mg.add(rank);
  }

  private void createLikedUserMenu(MenuGroup mg) {
    MenuGroup follow = new MenuGroup("좋아하는 유저", Menu.ACCESS_GENERAL);

    follow.add(new MenuItem("좋아하는 유저 등록하기", "/likedUser/add"));
    follow.add(new MenuItem("좋아하는 유저 목록보기", "/likedUser/list"));
    follow.add(new MenuItem("좋아하는 유저 삭제하기", "/likedUser/delete"));

    mg.add(follow);
  }

  private void createReportMenu(MenuGroup mg) {
    MenuGroup report = new MenuGroup("신고하기", Menu.ACCESS_GENERAL);

    report.add(new MenuItem("테마 신고", "/report/theme"));
    report.add(new MenuItem("유저 신고", "/report/user"));
    report.add(new MenuItem("나의 신고 목록", "/report/list"));

    report.add(new MenuItem("테마 신고 처리", Menu.ACCESS_ADMIN,"/report/themeProcess"));
    report.add(new MenuItem("유저 신고 처리", Menu.ACCESS_ADMIN,"/report/userProcess"));

    mg.add(report);
  }


}
