<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}"/>

<div class="container">
<div class="main-container">

<br>
<h1 style=text-align:center;>자유 게시글 목록 보기</h1>
<br>

<c:if test="${not empty loginUser}">
  <form action="search" style="float:right;">
    <a href="addform" class="btn btn-outline-dark">📝 자유 게시글 등록하기</a>
  </form>
  <br><br><br>
</c:if>

<table class="table table-hover">
  <thead>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>닉네임</th>
      <th>등록일</th>
      <th>조회수</th>
		</tr>
	</thead>
	
	<tbody>
	 <c:forEach items="${boardList}" var="board">
	   <tr>
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
