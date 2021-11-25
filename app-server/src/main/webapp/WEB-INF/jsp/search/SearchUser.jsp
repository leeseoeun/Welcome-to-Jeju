<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set scope="page" var="contextRoot"
  value="${pageContext.servletContext.contextPath}" />
<link rel="stylesheet" href="${contextRoot}/css/home.css?ver=1">
<link rel="stylesheet" href="${contextRoot}/css/theme_list.css">

  <div class="dash-board">
  <div class="hot-curators">
    <div class="title">
    <br>
    <br>
    <h1 style="text-align: center;">🔎 '${keyword}'로 검색한 유저 목록</h1>
    <br>
    <br>
    </div>
    <ul class="hot-curators-list .owl-carousel2">
      <c:forEach items="${userList}" var="user">
        <li><a href="../theme/userlist?no=${user.no}" class="content">
            <div class="icon">${user.emoji}</div>
            <div class="curator-name">${user.nickname}</div>
            <div class="theme-count">${user.registeredDate}</div>
        </a></li>
      </c:forEach>
    </ul>
  </div>
  </div>

