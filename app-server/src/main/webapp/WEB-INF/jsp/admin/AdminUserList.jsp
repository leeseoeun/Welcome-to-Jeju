<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

<br>
<h1 style=text-align:center;>유저 목록 보기</h1>
<br>

<!-- 유저 -->
<br>
<h3 style=text-align:center;>유저</h3>
<br>
<table class="table table-hover">
<thead>
<tr>
	<th>번호</th>
	<th>이메일</th>
	<th>닉네임</th>
	<th>가입일</th>
	<th>조회수</th>
	<th>상태</th>
</tr>
</thead>

<tbody>
<c:forEach items="${userList}" var="user">
	<c:choose>
	<c:when test="${user.active eq '1'}">
    <tr>
	    <td>${user.no}</td>
	    <td>${user.email}</td>
	    <td><a href='userdetail?no=${user.no}'>${user.nickname}</a></td>
	    <td>${user.registeredDate}</td>
	    <td>${user.viewCount}</td>
	    <td>회원</td>    
    </tr>
	</c:when>
	</c:choose>
</c:forEach>
</tbody>
</table>

<!-- 탈퇴한 유저 -->
<br>
<h3 style=text-align:center;>탈퇴한 유저</h3>
<br>
<table class = "table table-hover">
<thead>
<tr>
  <th>번호</th>
  <th>닉네임</th>
  <th>이메일</th>
  <th>등록일</th>
  <th>조회수</th>
  <th>상태</th>
</tr>
</thead>

<tbody>
<c:forEach items="${userList}" var="user">
  <c:choose>
  <c:when test="${user.active eq '0'}">
    <tr>
      <td>${user.no}</td>
      <td>${user.email}</td>
      <td><a href='userdetail?no=${user.no}'>${user.nickname}</a></td>
      <td>${user.registeredDate}</td>
      <td>${user.viewCount}</td>
      <td>회원</td>    
    </tr>
  </c:when>
  </c:choose>
</c:forEach>
</tbody>
</table>
