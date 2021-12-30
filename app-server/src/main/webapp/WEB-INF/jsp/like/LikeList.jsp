<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${contextRoot}/css/list.css">

<style>
  .like {
    width: 33.3%;
    float: left;
  }

  .like-title {
    margin-left: 50px;
    text-align: center;
  }
</style>

<div class="container">
<div class="main-container">

<br>
<h1 class="like-title">좋아요 목록 보기</h1>
<br>

<div class="like">
	<h3 class="like-title">유저 테마</h3>
	<ul class="theme-list">
	<c:forEach items="${publicThemeList}" var="theme" varStatus="status">
	  <a href='../liketheme/delete?themeNo=${theme.no}'>💔</a>
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
</div>  <!-- .like -->

<div class="like">
	<h3 class="like-title">참여 테마</h3>
	<ul class="theme-list">
	<c:forEach items="${shareThemeList}" var="theme" varStatus="status">
	  <a href='../liketheme/delete?themeNo=${theme.no}'>💔</a>
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
</div>  <!-- .like -->

<div class="like">
	<h3 class="like-title">유저</h3>
	<ul class="theme-list">
	<c:forEach items="${userList}" var="user" varStatus="status">
	  <a href='../likeuser/delete?userNo=${user.no}'>💔</a>
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
</div>  <!-- .like -->

</div>  <!-- .main-container -->
</div>  <!-- .container -->

<div style="clear:left"></div>
