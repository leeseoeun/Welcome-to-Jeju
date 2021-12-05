<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

<style>
  .add-form {
    width: 30%;
    background-color: transparent;
    margin: 0 auto;
    padding: 30px;
  }
</style>

<br>
<h1 style=text-align:center;>장소 등록하기</h1>
<br>

<div class="add-form">
<form id="place-form" action="add" method="post" enctype="multipart/form-data">

  <input type="hidden" id="id" name="id">
  <input type="hidden" id="address_name" name="address_name">
  <input type="hidden" id="x" name="x">
  <input type="hidden" id="y" name="y">

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
  <input id='f-photo' type='file' name='photoFile' class="form-control">
  </div>
</div>

<div class="mb-3 row">
<h5>후기</h5>
  <div class = "col-sm-16">
  <textarea id='f-comment' name='comment' rows="5" class="form-control"></textarea>
  </div>
</div>

<br>

<div class="text-center">
<button type="submit" class="btn btn-outline-dark">등록하기</button>
<button type="button" class="btn btn-outline-dark"><a href="list">취소하기</a></button>
</div>

</form>
</div>  <!-- .add-form -->

<!-- <script>
document.querySelector("#place-form").onsubmit = () => {
  if (document.querySelector("#f-comment").value == "") {
    window.alert("필수 입력 항목이 비어 있음!")
    return false;
  }
};
</script> -->
