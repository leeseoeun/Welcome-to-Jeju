<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set scope="page" var="contextRoot"
  value="${pageContext.servletContext.contextPath}" />
<jsp:include page="../template_head.jsp" />
<link rel="stylesheet" href="${contextRoot}/css/home.css?ver=1">
<script defer src="${contextRoot}/javascript/home.js"></script>

<style>
.form-select {
background-color: transparent;
color: black;
width: 250px;
border: none;

padding: .5em .3em;
font-family: inherit;
}

.select {
position: relative;
 top: 20px;
 left: 110px;
}
</style>

<br>
<br>
<br>

<h1 style="text-align: center;">검색 하기</h1>

<form id="search-form" action="${contextRoot}/app/search/all">

<div class=select>
<select class="form-select" name="option">
  <option selected> 검색 옵션을 선택해주세요!</option>
  <option value="all">전체검색</option>
  <option value="theme">테마</option>
  <option value="hashtag">해시태그</option>
  <option value="user">유저</option>
</select>
</div>

  <div class="search-container">
    <input type="text" placeholder="⌨ 키워드를 입력해주세요!" name="keyword"
      id="search-bar">
    <button class="search-icon">
      <i class="fas fa-search"></i>
    </button>
  </div>
</form>







