<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

<style>
  .info-form {
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
<h1 style=text-align:center;>나의 정보</h1>
<br>

<div class="info-form">
<form id="update-form" action="../user/update" method="post" enctype="multipart/form-data">

<div class="mb-3 row">
<h5>이메일</h5>
  <div class="col-sm-16">
  <input id='f-email' type='email' name='email' class="form-control" value="${loginUser.email}" readonly>
  </div>
</div>

<div class="mb-3 row">
<h5>비밀번호</h5>
  <div class="col-sm-16">
  <input id='f-password' type='password' name='password' class="form-control">
  </div>
</div>

<div class="mb-3 row">
<h5>닉네임</h5>
  <div class="col-sm-16">
  <input id='f-nickname' type='text' name='nickname' class="form-control" value="${loginUser.nickname}">
  </div>
</div>

<%-- <div class="mb-3 row">
<h5>조회수</h5>
  <div class="col-sm-16">
  <input id='f-viewCount' type='text' name='viewCount' class="form-control" value="${loginUser.viewCount}" readonly>
  </div>
</div> --%>

<div class="mb-3 row">
<h5>가입</h5>
  <div class="col-sm-16">
  <input id='f-registeredDate' type='date' name='registeredDate' class="form-control" value="${loginUser.registeredDate}" readonly>
  </div>
</div>

<br>

<div class="text-center">
<button type="submit" class="btn btn-outline-dark">수정하기</button>
<button class="btn btn-outline-dark"><a href="../user/delete?no=${loginUser.no}">탈퇴하기</a></button>
</div>

</form>
</div>

<script>
document.querySelector("#update-form").onsubmit = () => {
  if (document.querySelector("#f-password").value == "" ||
      document.querySelector("#f-nickname").value == "") {
    window.alert("비밀번호 또는 닉네임 입력!")
    return false;
  }
};
</script>
