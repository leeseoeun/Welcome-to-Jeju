<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set scope="page" var="contextRoot"
  value="${pageContext.servletContext.contextPath}" />
<link rel="stylesheet" href="${contextRoot}/css/home.css?ver=1">
<link rel="stylesheet" href="${contextRoot}/css/theme_list.css">

<style>
.btn btn-outline-dark btn-lg {
right: 600px;

}

</style>

<div class="dash-board">
<br><br><br><br><br>
<h1 style="text-align: center;">나의 테마 목록 보기</h1>
<h1><a href='addform' class="btn btn-outline-dark btn-lg"  style="margin-left: 850px;">🎨 나의 테마 만들기</a></h1>

    <div class="hot-theme">
    <div class="title">
    <br>
    <br>
    <h2 style="text-align: center;">공개테마</h2>
    <br>
    <br>
    </div>
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
      <c:forEach begin="0" end="${3-(fn:length(publicThemeList)%3)-1}">
        <a class="list-container" style="visibility: hidden;">
          <li>
            <div class="content">
              <div class="icon">${theme.no}</div>
              <div class="theme-title">${theme.title}</div>
            </div> <!-- .content -->
        </li>
        </a>
      </c:forEach>
    </ul>
  </div>
  
  <div class="hot-theme">
     <div class="title">
    <br>
    <br>
    <h2 style="text-align: center;">비공개 테마</h2>
    <br>
    <br>
    </div>
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
      <c:forEach begin="0" end="${3-(fn:length(privateThemeList)%3)-1}">
        <a class="list-container" style="visibility: hidden;">
          <li>
            <div class="content">
              <div class="icon">${theme.no}</div>
              <div class="theme-title">${theme.title}</div>
            </div> <!-- .content -->
        </li>
        </a>
      </c:forEach>
    </ul>
  </div>
  </div>

