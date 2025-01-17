<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}"/>
<jsp:include page="../template_head.jsp"/>
<link rel="stylesheet" href="${contextRoot}/css/theme_list.css">
<link rel="stylesheet" href="${contextRoot}/css/home.css">
<script defer src="${contextRoot}/javascript/home.js"></script>

<div class="container">
<div class="main-container">

<br>
<h1 style=text-align:center;>🏆 유저 테마 순위</h1>
<br>

<ul class="theme-list">
<c:forEach items="${publicThemeList}" var="theme" varStatus="status">
<c:set var="i" value="${i+1}"/>
  <a class="list-container" href="place/list?no=${theme.no}">
  <td> 🏅 ${i}등 </td>
    <li>
    <div class="content">
      <div class="icon">${theme.emoji}</div>
      <div class="theme-title">${theme.title}</div>
    </div>  <!-- .content -->
    </li>
  </a>
</c:forEach>  
<c:forEach begin="0" end="${3-(fn:length(publicThemeList)%3)-1}">
    <a class="list-container" style=visibility:hidden;>
      <li>
        <div class="content">
          <div class="icon">${theme.emoji}</div>
          <div class="theme-title">${theme.title}</div>
        </div>  <!-- .content -->
      </li>
    </a>
</c:forEach>
</ul>

<br>
<h1 style=text-align:center;>🏆 참여 테마 순위</h1>
<br>

<ul class="theme-list">
<c:forEach items="${shareThemeList}" var="theme" varStatus="status">
<c:set var="y" value="${y+1}"/>
  <a class="list-container" href="place/list?no=${theme.no}">
  <td> 🏅 ${y}등 </td>
    <li>
    <div class="content">
      <div class="icon">${theme.emoji}</div>
      <div class="theme-title">${theme.title}</div>
    </div>  <!-- .content -->
    </li>
  </a>
</c:forEach>  
<c:forEach begin="0" end="${3-(fn:length(shareThemeList)%3)-1}">
    <a class="list-container" style=visibility:hidden;>
      <li>
        <div class="content">
          <div class="icon">${theme.emoji}</div>
          <div class="theme-title">${theme.title}</div>
        </div>  <!-- .content -->
      </li>
    </a>
</c:forEach>
</ul>


<br>
<h1 style=text-align:center;>🏆 유저 순위</h1>
<br>

<ul class="theme-list">
<c:forEach items="${userList}" var="user" varStatus="status">
<c:set var="z" value="${z+1}"/>
  <a class="list-container" href="user/themelist?no=${user.no}">
  <td> 🏅 ${z}등 </td>
    <li>
    <div class="content">
      <div class="icon">${user.emoji}</div>
      <div class="theme-title">${user.nickname}</div>
    </div>  <!-- .content -->
    </li>
  </a>
</c:forEach>  
<c:forEach begin="0" end="${3-(fn:length(userList)%3)-1}">
    <a class="list-container" style=visibility:hidden;>
      <li>
        <div class="content">
          <div class="icon">${user.emoji}</div>
          <div class="theme-title">${user.nickname}</div>
        </div>  <!-- .content -->
      </li>
    </a>
</c:forEach>
</ul>

</div>  <!-- .main-container -->
</div>  <!-- .container -->

