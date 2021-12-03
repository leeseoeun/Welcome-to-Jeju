<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set scope="page" var="contextRoot"
  value="${pageContext.servletContext.contextPath}" />
<link rel="stylesheet" href="${contextRoot}/css/home.css?ver=1">
<link rel="stylesheet" href="${contextRoot}/css/theme_list.css">

  <div class="hot-theme">
    <div class="title">
    <br>
    <br>
    <h1 style="text-align: center;">🔎 '${keyword}'로 검색한 유저 테마 목록</h1>
    <br>
    <br>
    </div>
    <ul class="theme-list">
      <c:forEach items="${publicThemeList}" var="theme">
        <a class="list-container" href="../place/list?no=${theme.no}">
          <li>
            <div class="content">

              <c:if test="${!empty theme.emoji}">
                <div class="icon">${theme.emoji}</div>
              </c:if>
              <c:if test="${empty theme.emoji}">
                <div class="icon">🏄</div>
              </c:if>
              <div class="theme-title">${theme.title}</div>
            </div> <!-- .content -->
        </li>
        </a>
      </c:forEach>
      <c:forEach begin="0" end="${3-(fn:length(themeList)%3)-1}">
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

