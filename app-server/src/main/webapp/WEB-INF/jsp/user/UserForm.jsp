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
  margin-left: 20px;
  margin-right: 20px;
  }
  
  </style>
  
<div class="card-container">
  <div class="card align-middle" style="width:20rem; border-radius:20px;">
    <div class="card-title" style="margin-top:30px;">
      <h2 class="card-title text-center" style="color:#113366;">추가 정보</h2>
    </div>
<div class = "card-body">
<form id="user-form" action='update' method='post'>

<div class="mb-3 row">
<h5>회원번호</h5>
  <div class = "col-sm-16">
  <input id='f-no' type='text' name='no' class="form-control" value='${loginUser.no}' readonly>
  </div>
  </div>
  
<div class="mb-3 row">
<h5>이메일</h5>
  <div class = "col-sm-16">
  <input id='f-email' type='text' name='email' class="form-control" value='${loginUser.email}' readonly>
  </div>
  </div>  
  
<h5>이모지</h5>
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
<h5>닉네임</h5>
  <div class = "col-sm-16">
  <input id='f-nickname' type='text' name='nickname' class="form-control">
  <div class="invalid-feedback">
        이미 존재하는 닉네임입니다.
    </div>
  </div>
  <div class="col-auto">
    <button id="x-nickname-check-btn" type="button" class="btn btn-outline-dark form-control"
    style="color : #ffff; background-color:#F6BB43; border:none; margin-left: 197px; width: 85px;">중복검사</button>
  </div>
</div>

<button type='submit' id="x-add-btn" class="btn btn-lg btn-primary btn-block" 
style = "color : #ffff; background-color:#F6BB43; border:none;">저장하기</button>
</form>

<form class = "form-login" action = "../auth/loginform">
<button class="btn btn-lg btn-primary btn-block"
style = "color : #ffff; background-color:#F6BB43; border:none;">로그인</button>
</form>
</div>
</div>
</div>

<script>
document.querySelector("#user-form").onsubmit = () => {
      document.querySelector("#f-nickname").value == "") {
    window.alert("필수 입력 항목이 비어 있음!")
    return false;
  }
};

var addBtn = document.querySelector("#x-add-btn");
var nicknameTag = document.querySelector("#f-nickname");
addBtn.setAttribute("disabled", "disabled");

document.querySelector("#x-nickname-check-btn").onclick = () => {
    var xhr = new XMLHttpRequest();
    xhr.addEventListener("load", function() {
      if (this.responseText == "false") {
          addBtn.removeAttribute("disabled");
          nicknameTag.classList.remove("is-invalid");
      } else {
        addBtn.setAttribute("disabled", "disabled");
        nicknameTag.classList.add("is-invalid");
      }
    })
    xhr.open("get", "checkNickname?nickname=" + nicknameTag.value);
    xhr.send();
};

</script>

    