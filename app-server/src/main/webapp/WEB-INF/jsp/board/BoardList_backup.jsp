<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${contextRoot}/css/theme_list.css">

<div class="container">
<div class="main-container">

<br>
<h1 style=text-align:center;>게시글 목록 보기</h1>
<br>

<c:choose>
<c:when test="${loginUser ne null}">
<ul class="theme-list">
<a class="list-container" href="addform">
	  <li>
	  <div class="content">
	  <div class="icon">➕</div>
	  <div class="theme-title">게시글 등록하기</div>
	  </div>  <!-- .content -->
	  </li>
</a>
</ul>
</c:when>
</c:choose>

<ul class="theme-list">
<c:forEach items="${boardList}" var="board">
	<%-- <c:choose>
	<c:when test="${theme.isPublic eq '1'}"> --%>
		<a class="list-container" href="detail?no=${board.no}">
      <li>
		    <div class="content">
				<%-- <div class="icon">${board.emoji}</div> --%>
				<div class="theme-title">${board.title}</div>
				<%-- <div class="theme-count">#${board.hashtags}</div> --%>
			</div>  <!-- .content -->
			</li>
	  </a>
	<%-- </c:when>
	</c:choose> --%>
</c:forEach>
<c:forEach begin="0" end="${3-(fn:length(boardList)%3)-1}">
		<a class="list-container" style=visibility:hidden;>
      <li>
		    <div class="content">
					<%-- <div class="icon">${board.emoji}</div> --%>
					<div class="theme-title">${board.title}</div>
					<%-- <div class="theme-count">#${board.hashtags}</div> --%>
				</div>  <!-- .content -->
			</li>
	  </a>
</c:forEach>

</ul>

</div>  <!-- .main-container -->
</div>  <!-- .container -->
