<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<style>
.add-form {
	width: 30.5%;
	background-color: transparent;
	margin: 0 auto;
	padding: 30px;
}

.form-select {
	margin-bottom: 15px;
}
</style>

<br>
<h1 style="text-align:center;">자유 게시글 등록하기</h1>
<br>

<div class="add-form">
	<form id="theme-form" action="add" method="post" enctype="multipart/form-data">

		<div class="mb-3 row">
			<h5>제목</h5>
			<div class="col-sm-16">
				<input id='f-title' type='text' name='title' class="form-control">
			</div>
		</div>

		<div class="mb-3 row">
			<h5>닉네임</h5>
			<div class="col-sm-16">
				<input id='f-owner' type='text' class="form-control" value="${loginUser.nickname}" readonly>
			</div>
		</div>

		<div class="mb-3 row">
			<h5>내용</h5>
			<div class="col-sm-16">
				<textarea id='f-content' name='content' class="form-control" rows="5">${board.content}</textarea>
			</div>
		</div>

		<br>

		<div class="text-center">
			<button type="submit" class="btn btn-outline-dark">등록하기</button>
		</div>

	</form>
</div>

<script>
document.querySelector("#theme-form").onsubmit = () => {
  if (document.querySelector("#f-title").value == "" ||
      document.querySelector("#f-content").value == "") {
    window.alert("필수 입력 항목이 비어 있음!")
    return false;
  }
};
</script>
