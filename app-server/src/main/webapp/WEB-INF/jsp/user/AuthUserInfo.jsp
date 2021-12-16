
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

<style>
 .card-container{
    display : flex;
    justify-content: center;
    padding: var(--font-great) 0 ;
}
  .btn-block {
    float:left;
    margin-right:10px;
    }
</style>
    

<div class="card-container">
  <div class="card align-middle" style="width:20rem; border-radius:20px;">
    <div class="card-title" style="margin-top:30px;">
      <h2 class="card-title text-center" style="color:#113366;">내 정보</h2>
    </div>
<div class = "card-body">
<form id = "update-form" action='../user/update' method='post'>

  <input id='f-no' type='hidden' name='no' value="${loginUser.no}" class="form-control"  readonly>

<div class="mb-3 row">
<h5>이메일</h5>
  <div class="col-sm-16">
  <input id='f-email' type='email' name='email' value='${loginUser.email}' class="form-control" readonly>
  </div>
</div>

<div class="mb-3 row">
<h5>암호</h5>
  <div class="col-sm-16">
  <input id='f-password' type='password' name='password' class="form-control" >
  </div>
</div>

<div class="mb-3 row">
<h5>닉네임</h5>
  <div class = "col-sm-16">
  <input id='f-nickname' type='text' name='nickname' class="form-control" value = "${loginUser.nickname}">
  <div class="invalid-feedback">
        이미 존재하는 닉네임입니다.
    </div>
  </div>
  <div class="col-auto">
    <button id="x-nickname-check-btn" type="button" class="btn btn-outline-dark form-control"
    style="color : #ffff; background-color:#F6BB43; border:none; margin-left: 197px; width: 85px;">중복검사</button>
  </div>
</div>

<div class="mb-3 row">
<h5>이모지</h5>
  <div class="col-sm-16">
  <input id='f-emoji' type='text' class="form-control" value = "${loginUser.emoji}" readonly>
  </div>
</div>

<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#129503;" checked>
  <label class="form-check-label" for="inlineCheckbox1">&#129503;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#128060;">
  <label class="form-check-label" for="inlineCheckbox1">&#128060;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#128120;">
  <label class="form-check-label" for="inlineCheckbox1">&#128120;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#128115;">
  <label class="form-check-label" for="inlineCheckbox1">&#128115;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#129333;">
  <label class="form-check-label" for="inlineCheckbox1">&#129333;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#128048;">
  <label class="form-check-label" for="inlineCheckbox1">&#128048;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#129412;">
  <label class="form-check-label" for="inlineCheckbox1">&#129412;</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" id="f-emoji" name="emoji" value="&#129337;">
  <label class="form-check-label" for="inlineCheckbox1">&#129337;</label>
</div>

<br><br>

<div class="mb-3 row">
<h5>조회수</h5>
  <div class="col-sm-16">
  <input id='f-viewCount' type='text' name='viewCount' value='${loginUser.viewCount}' class="form-control"  readonly>
  </div>
</div>

<div class="mb-3 row">
<h5>가입일</h5>
  <div class="col-sm-16">
  <input id='f-registeredDate' type='text' name='registeredDate' value='${loginUser.registeredDate}' class="form-control"  readonly><br>
  </div>
</div>

<button type='submit' id ="x-update-btn" class="btn btn-outline-dark btn-block" 
style = "color : #ffff; background-color:#F6BB43; border:none;">회원 수정</button>
</form>

<button class="btn btn-outline-dark btn-block"
style = "color : #ffff; background-color:#F6BB43; border:none;">
<a href="../user/delete?no=${loginUser.no}">탈퇴하기</a></button>

<form class="form-logout" action = "logout">
<button class="btn btn-outline-dark btn-block"
style = "color : #ffff; background-color:#F6BB43; border:none;">로그아웃</button>
</form>

</div>
</div>
</div>

<script>
document.querySelector("#update-form").onsubmit = () => {
	  if (document.querySelector("#f-password").value == "" ) {
	      window.alert("필수 입력 항목이 비어 있음!")
	      return false;
	    }
	  };

var updateBtn = document.querySelector("#x-update-btn");
var nicknameTag = document.querySelector("#f-nickname");
updateBtn.setAttribute("disabled", "disabled");

document.querySelector("#x-nickname-check-btn").onclick = () => {
    var xhr = new XMLHttpRequest();
    xhr.addEventListener("load", function() {
      if (this.responseText == "false") {
    	  updateBtn.removeAttribute("disabled");
          nicknameTag.classList.remove("is-invalid");
      } else {
    	  updateBtn.setAttribute("disabled", "disabled");
        nicknameTag.classList.add("is-invalid");
      }
    })
    xhr.open("get", "../user/checkNickname?nickname=" + nicknameTag.value);
    xhr.send();
};

</script>


