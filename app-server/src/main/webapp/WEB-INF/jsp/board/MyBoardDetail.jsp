<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
  <input id='f-title' type='text' name='title' class="form-control" value="${board.title}" >
  </div>
</div>

<div class="mb-3 row">
<h5>내용</h5>
  <div class="col-sm-16">
  <textarea id='f-content' name='content' class="form-control" rows="5" >${board.content}</textarea>
  </div>
</div>

<div class="mb-3 row">
<h5>조회수</h5>
  <div class="col-sm-16">
  <input id='f-viewcount' type='text' name='viewcount' class="form-control" value="${board.viewCount}" readonly>
  </div>
</div>

<div class="text-center">
<button type='submit' class="btn btn-outline-dark">수정하기</button>
<a href='delete?no=${board.no}' class="btn btn-outline-dark">삭제하기</a> 
<a href='list' class="btn btn-outline-dark">목록</a><br>
</div>

</form>
<br>

<div class="comment-form">
<div class="card mb-2">
  <div class="card-header bg-light">
          <i class="fa fa-comment fa"></i> 댓글
  </div>
  <div class="card-body">

        <table class="table table-hover">
<thead>
  <tr>
    <th>닉네임</th>
    <th>내용</th>
    <th>등록일</th>
    <th></th>
    
  </tr>
</thead>
<tbody>

<c:forEach items="${boardComment}" var="comment">
<tr data-no="${comment.no}">
    <td>${comment.writer.nickname}</td> 
    <td>${comment.content}</td> 
    <td>${comment.registeredDate}</td>
    
    <c:choose>
    <c:when test="${loginUser.nickname eq comment.writer.nickname}">
    <td><a href='../boardcomment/delete?no=${comment.no}&boardNo=${board.no}'>🗑️</a></td>
    </c:when>
    <c:otherwise>
    </c:otherwise>
    </c:choose>
    
</tr>
</c:forEach>

</tbody>
</table>
  
    <ul class="list-group list-group-flush">
        <li class="list-group-item">
      <form id="comment_update-form" action='../boardcomment/add' method='post'>
      <div class="form-inline mb-2">
        <input id='f-no' type='hidden' name='board.no' class="form-control" value="${board.no}" readonly>
        <input id='f-nickname' type='hidden' name='writer.nickname' class="form-control" value="${loginUser.nickname}" readonly>
        <input id='f-writer_no' type='hidden' name='writer.no' class="form-control" value="${loginUser.no}" readonly>
      </div>
      <textarea class="form-control" id="exampleFormControlTextarea1" name='content' rows="3"></textarea>
      <br>
      <button type='submit' class="btn btn-outline-dark">댓글 쓰기</button>
        </form>
        </li>
    </ul>
  </div>
      </div>
      </div> <!-- .comment-form -->
</div>

