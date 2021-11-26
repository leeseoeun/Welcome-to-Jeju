<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set scope="page" var="contextRoot"
  value="${pageContext.servletContext.contextPath}" />
<jsp:include page="../template_head.jsp" />
<link rel="stylesheet" href="${contextRoot}/css/home.css?ver=1">
<script defer src="${contextRoot}/javascript/home.js"></script>

<style>
.checkbox-inline {
background-color: transparent;
color: black;
font-family: inherit;
font-size: x-large;
position: relative;
left: 150px;
}

</style>

<br>
<br>
<br>
<h1 style="text-align: center;">검색 하기</h1>
<br>

<form id="search-form" action="${contextRoot}/app/search/all">
<!-- 
<select class="form-select" name="option">
  <option selected> 검색 옵션을 선택해주세요!</option>
  <option value="all">전체검색</option>
  <option value="theme">테마</option>
  <option value="hashtag">해시태그</option>
  <option value="user">유저</option>
</select>
 -->

<label class="checkbox-inline">
  <input type="checkbox" name="option" id="inlineCheckbox1" value="all"> 전체검색
</label>
<label class="checkbox-inline">
  <input type="checkbox" name="option" id="inlineCheckbox2" value="theme"> 테마
</label>
<label class="checkbox-inline">
  <input type="checkbox" name="option" id="inlineCheckbox3" value="hashtag"> 해시태그
</label>
<label class="checkbox-inline">
  <input type="checkbox" name="option" id="inlineCheckbox3" value="user"> 유저
</label>


<br>
  <div class="search-container">
    <input type="text" placeholder="⌨ 키워드를 입력해주세요!" name="keyword"
      id="search-bar">
    <button class="search-icon">
      <i class="fas fa-search"></i>
    </button>
  </div>
</form>







