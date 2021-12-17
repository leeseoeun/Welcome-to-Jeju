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
	<div class="col-sm-12">
	<input id='f-place' type='text' name='place_name' class="form-control" value="${place.place_name}" readonly>
	</div>
</div>

<div class="mb-3 row">
<h5>주소</h5>
  <div class = "col-sm-12">
  <input id='f-address' name='address_name' type='text' class="form-control" value="${place.address_name}" readonly>
  </div>
</div>

<div class="mb-3 row">
<h5>사진</h5>
  <c:forEach items="${photoList}" var="placePhoto">
	  <a href="${contextPath}/upload/place/${placePhoto.filePath}">
	    <img id="f-photo-image" src="${contextPath}/upload/place/${placePhoto.filePath}_100x100.jpg" class="img-rounded">
	  </a>
  </c:forEach>
</div>

<div class="mb-3 row">
<h5>후기</h5>
  <c:forEach items="${commentList}" var="placeComment">
  <div class="form-group">
    <label class="col-sm-5 control-label">${placeComment.writer.emoji}${placeComment.writer.nickname}</label>
    
    <div class="col-sm-12">
      <textarea type="text" class="form-control" id="inputPassword3" rows="5" style="margin-bottom: 13px;" readonly>${placeComment.comment}</textarea>
    </div>
  </div>
    <br><br>
  </c:forEach>
</div>

<!-- </form> -->
</div>  <!-- .detail -->
