<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

<style>
  .add-form {
    width: 30%;
    /* border-radius: 6px; */
    /* box-shadow: 3px 3px; */
    background-color: transparent;
    /* background-color: #f8f8f8; */
    /* background-color: #F6BB43; */
    /* text-align: center; */
    margin: 0 auto;
    padding: 30px;
  }
</style>

<br>
<h1 style=text-align:center;>장소 상세 보기</h1>
<br>

<div class="add-form">
<form id="place-form" action="add" method="post" enctype="multipart/form-data">

<div class="mb-3 row">
<h5>장소 아이디</h5>
	<div class="col-sm-16">
	<input id='f-place' type='text' name='id' class="form-control" value="${place.id}" readonly>
	</div>
</div>
<div class="mb-3 row">
<h5>x</h5>
	<div class="col-sm-16">
	<input id='f-place' type='text' name='x' class="form-control" value="${place.x}" readonly>
	</div>
</div>
<div class="mb-3 row">
<h5>y</h5>
	<div class="col-sm-16">
	<input id='f-place' type='text' name='y' class="form-control" value="${place.y}" readonly>
	</div>
</div>

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
  <input id='f-photo' type='file' name='photoFile' class="form-control" value="${place.photos}">
  </div>
</div>

<div class="mb-3 row">
<h5>후기</h5>
  <div class = "col-sm-16">
  <input id='f-comment' type='text' name='comment' class="form-control" value="${place.comments}">
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
document.querySelector("#theme-form").onsubmit = () => {
  if (document.querySelector("#f-title").value == "" ||
      document.querySelector("#f-category").value == "" ||
      document.querySelector("#f-hashtag").value == "") {
    window.alert("필수 입력 항목이 비어 있음!")
    return false;
  }
};
</script> -->
