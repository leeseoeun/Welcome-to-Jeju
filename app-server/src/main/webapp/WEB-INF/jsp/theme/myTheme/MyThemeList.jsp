<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${contextRoot}/css/theme_list.css">

<div class="container">
<div class="main-container">

<br>
<h1 style=text-align:center;>나의 테마 목록 보기</h1>
<br>

<form action="search" style="float:right;">
  <a href="addform" class="btn btn-outline-dark">🎨 나의 테마 만들기</a>
</form>

<br>

<br>
<h3 style=text-align:center;>공개 테마</h3>
<br>
<ul class="theme-list">
<c:forEach items="${publicThemeList}" var="theme">
  <a class="list-container" href="../place/list?no=${theme.no}">
    <li>
    <div class="content">
      <div class="icon">${theme.emoji}</div>
      <div class="theme-title">${theme.title}</div>
    </div>  <!-- .content -->
    </li>
  </a>
</c:forEach>
<c:forEach begin="0" end="${3-(fn:length(themeList)%3)-1}">
    <a class="list-container" style=visibility:hidden;>
      <li>
        <div class="content">
          <div class="icon">${theme.no}</div>
          <div class="theme-title">${theme.title}</div>
        </div>  <!-- .content -->
      </li>
    </a>
</c:forEach>
</ul>

<br>
<h3 style=text-align:center;>비공개 테마</h3>
<br>
<ul class="theme-list">
<c:forEach items="${privateThemeList}" var="theme">
  <a class="list-container" href="../place/list?no=${theme.no}">
    <li>
    <div class="content">
      <div class="icon">${theme.emoji}</div>
      <div class="theme-title">${theme.title}</div>
    </div>  <!-- .content -->
    </li>
  </a>
</c:forEach>
<c:forEach begin="0" end="${3-(fn:length(themeList)%3)-1}">
    <a class="list-container" style=visibility:hidden;>
      <li>
        <div class="content">
          <div class="icon">${theme.no}</div>
          <div class="theme-title">${theme.title}</div>
        </div>  <!-- .content -->
      </li>
    </a>
</c:forEach>
</ul>

</div>  <!-- .main-container -->
</div>  <!-- .container -->
