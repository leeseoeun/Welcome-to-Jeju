<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${contextRoot}/css/ranking.css">

<style>
  .ranking {
    width: 33.3%;
    float: left;
  }

  .ranking-title {
    margin-left: 50px;
    text-align: center;
  }
</style>

<div class="container">
<div class="main-container">

<br>
<h1 class="ranking-title">좋아요 목록 보기</h1>
<br>

<div class="ranking">
<br>
<h3 class="ranking-title">유저 테마</h3>
<br>
<ul class="theme-list">
<c:forEach items="${publicThemeList}" var="theme" varStatus="status">
  <a href='delete?no=${theme.no}'>💔</a>
  <a class="list-container" href="place/list?no=${theme.no}">
    <li>
    <div class="content">
      <div class="icon">${theme.emoji}</div>
      <div class="theme-title">${theme.title}</div>
    </div>  <!-- .content -->
    </li>
  </a>
</c:forEach>
</ul>
</div>

<div class="ranking">
<br>
<h3 class="ranking-title">참여 테마</h3>
<br>
<ul class="theme-list">
<c:forEach items="${shareThemeList}" var="theme" varStatus="status">
  <a href='delete?no=${theme.no}'>💔</a>
  <a class="list-container" href="place/list?no=${theme.no}">
    <li>
    <div class="content">
      <div class="icon">${theme.emoji}</div>
      <div class="theme-title">${theme.title}</div>
    </div>  <!-- .content -->
    </li>
  </a>
</c:forEach>
</ul>
</div>

<div class="ranking">
<br>
<h3 class="ranking-title">유저</h3>
<br>
<ul class="theme-list">
<c:forEach items="${userList}" var="user" varStatus="status">
  <a href='delete?no=${user.no}'>💔</a>
  <a class="list-container" href="user/themelist?no=${user.no}">
    <li>
    <div class="content">
      <div class="icon">${user.emoji}</div>
      <div class="theme-title">${user.nickname}</div>
    </div>  <!-- .content -->
    </li>
  </a>
</c:forEach>
</ul>
</div>

</div>  <!-- .main-container -->
</div>  <!-- .container -->

<div style="clear:left"></div>
