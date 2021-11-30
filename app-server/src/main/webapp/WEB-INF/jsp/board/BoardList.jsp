<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}"/>
<jsp:include page="../template_head.jsp"/>
<link rel="stylesheet" href="${contextRoot}/css/theme_list.css">

<div class="container">
<div class="main-container">
<br>
<h1 style=text-align:center;>게시글 목록 보기</h1>
<br>

<c:choose>
<c:when test="${loginUser ne null}">
<a href='addform' class="btn btn-outline-primary btn-sm">게시글 등록하기</a><br>
</c:when>
</c:choose>

<table class="table table-hover">
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>등록일</th>
    <th>조회수</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${boardList}" var="board">
<tr data-no="${board.no}">
    <td>${board.no}</td>
    <td><a href='detail?no=${board.no}'>${board.title}</a></td> 
    <td>${board.writer.nickname}</td> 
    <td>${board.registeredDate}</td> 
    <td>${board.viewCount}</td>
</tr>
</c:forEach>

</tbody>
</table>
</div>  <!-- .main-container -->
</div>  <!-- .container -->
