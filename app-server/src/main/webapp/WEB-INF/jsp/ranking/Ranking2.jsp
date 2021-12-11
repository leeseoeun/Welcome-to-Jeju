<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${contextRoot}/css/theme_list2.css">

<div class="container">
<div class="main-container">

<div class="public-theme-ranking" style="width:33%; float: left;">
<br>
<h3 style=text-align:center;>유저 테마</h3>
<br>
<ul class="theme-list">
<c:forEach items="${publicThemeList}" var="theme" varStatus="status">
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

<div class="share-theme-ranking" style="width:33%; float: left;">
<br>
<h3 style=text-align:center;>참여 테마</h3>
<br>
<ul class="theme-list">
<c:forEach items="${shareThemeList}" var="theme" varStatus="status">
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

<div class="user-ranking" style="width:33%; float: left;">
<br>
<h3 style=text-align:center;>유저</h3>
<br>
<ul class="theme-list">
<c:forEach items="${userList}" var="user" varStatus="status">
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
