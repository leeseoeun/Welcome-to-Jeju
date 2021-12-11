<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${contextRoot}/css/user_list.css">

<div class="container">
<div class="main-container">

<br>
<h1 style=text-align:center;>내가 좋아하는 유저 보기</h1>
<br>

<div class="dash-board">
  <div class="hot-curators">
    <div class="title"></div>
    <ul class="hot-curators-list">
      <c:forEach items="${userList}" var="user">
        <li>
          <a href="../theme/userlist?no=${user.no}" class="content">
            <div class="icon">${user.emoji}</div>
            <div class="curator-name">${user.nickname}</div>
          </a>
        </li>
        <a href='delete?themeNo=${theme.no}'>❌</a>
      </c:forEach>
    </ul>
  </div>  <!-- .hot-curators -->
</div>  <!-- .dash-board -->

</div>  <!-- .main-container -->
</div>  <!-- .container -->