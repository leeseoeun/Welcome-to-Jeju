<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
  .detail {
    width: 30%;
    background-color: transparent;
    margin: 0 auto;
    padding: 30px;
  }
</style>

<br>
<h1 style=text-align:center;>장소 상세 보기</h1>
<br>

<div class="detail">
<!-- <form id="place-form" action="add" method="post" enctype="multipart/form-data"> -->

<div class="mb-3 row">
<h5>장소 이름</h5>
	<div class="col-sm-16">
	<input id='f-place' type='text' name='place_name' class="form-control" value="${place.place_name}" readonly>
	</div>
</div>

<div class="mb-3 row">
<h5>주소</h5>
  <div class = "col-sm-16">
  <input id='f-address' name='address_name' type='text' class="form-control" value="${place.address_name}" readonly>
  </div>
</div>

<div class="mb-3 row">
<h5>사진</h5>
  <div class = "col-sm-16">
  <a href="${contextPath}/upload/place/${place.photos}">
    <img id="f-photo-image" src="${contextPath}/upload/place/${place.photos}_100x100.jpg">
  </a>
  </div>
</div>

<div class="mb-3 row">
<h5>후기</h5>
  <div class = "col-sm-16">
  <input id='f-comment' type='text' name='comment' class="form-control" value="${place.comments}">
  </div>
</div>

<!-- </form> -->
</div>  <!-- .detail -->
