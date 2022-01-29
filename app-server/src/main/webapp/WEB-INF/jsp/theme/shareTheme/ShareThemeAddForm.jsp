<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<style>
  .add-form {
    width: 30%;
    background-color: transparent;
    margin: 0 auto;
    padding: 30px;
  }
  
  .form-select {
    margin-bottom: 15px;
  }
</style>

<br>
<h1 style=text-align:center;>참여 테마 만들기</h1>
<br>

<div class="add-form">
<form id="theme-form" action="add" method="post" enctype="multipart/form-data">

<div class="mb-3 row">
<h5>테마 이름</h5>
  <div class="col-sm-16">
  <input id='f-title' type='text' name='title' class="form-control" >
  </div>
</div>

<div class="mb-3 row">
<h5>닉네임</h5>
  <div class = "col-sm-16">
  <input id='f-owner' type='text' class="form-control" value="${loginUser.nickname}" readonly>
  </div>
</div>

<h5>이모지</h5>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#127749;" checked>
  <label class="form-check-label" for="inlineCheckbox1">&#127749;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#128674;">
  <label class="form-check-label" for="inlineCheckbox1">&#128674;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#128044;">
  <label class="form-check-label" for="inlineCheckbox1">&#128044;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#127796;">
  <label class="form-check-label" for="inlineCheckbox1">&#127796;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#127818;">
  <label class="form-check-label" for="inlineCheckbox1">&#127818;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#129372;">
  <label class="form-check-label" for="inlineCheckbox1">&#129372;</label>
</div>

<br><br>

<div>
<h5>카테고리</h5>
<select class="form-select" aria-label="f-category" id="f-category" name="category">
  <option selected value="">👇</option>
  <option value="1">식당</option>
  <option value="2">카페</option>
  <option value="3">관광명소</option>
  <option value="4">기타</option>
</select>
</div>

<br>

<div class="text-center">
<button type="submit" class="btn btn-outline-dark">만들기</button>
</div>

</form>
</div>

<script>
document.querySelector("#theme-form").onsubmit = () => {
  if (document.querySelector("#f-title").value == "" ||
      document.querySelector("#f-emoji").value == "" ||
      document.querySelector("#f-category").value == "") {
    window.alert("필수 입력 항목이 비어 있음!")
    return false;
  }
};
</script>
