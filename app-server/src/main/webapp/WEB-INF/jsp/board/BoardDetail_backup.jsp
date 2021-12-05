<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

<style>
  .detail-form {
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
<h1 style=text-align:center;> 게시글 상세보기 </h1>
<br>

<div class="detail-form">
<form id="update-form" action='update' method='post'>

<div class="mb-3 row">
<h5>글번호</h5>
  <div class="col-sm-16">
  <input id='f-no' type='text' name='no' class="form-control" value="${board.no}" readonly>
  </div>
</div>

<div class="mb-3 row">
<h5>닉네임</h5>
  <div class="col-sm-16">
  <input id='f-nickname' type='text' name='nickname' class="form-control" value="${board.writer.nickname}" readonly>
  </div>
</div>

<div class="mb-3 row">
<h5>제목</h5>
  <div class="col-sm-16">
  <input id='f-title' type='text' name='title' class="form-control" value="${board.title}" readonly>
  </div>
</div>

<div class="mb-3 row">
<h5>내용</h5>
  <div class="col-sm-16">
  <textarea id='f-content' name='content' class="form-control" rows="5" readonly>${board.content}</textarea>
  </div>
</div>

<div class="mb-3 row">
<h5>조회수</h5>
  <div class="col-sm-16">
  <input id='f-viewcount' type='text' name='viewcount' class="form-control" value="${board.viewCount}" readonly>
  </div>
</div>

<br>

<div class="text-center">
<a href='list' class="btn btn-outline-dark">목록</a><br>
</div>

</form>

</div>
