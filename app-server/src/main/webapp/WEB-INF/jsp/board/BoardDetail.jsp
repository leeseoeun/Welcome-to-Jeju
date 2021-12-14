<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../template_head.jsp" />

<div class="container">
	<div class="main-container">
		<br>
		<h1 style="text-align: center;">게시글 상세보기</h1>
		<br>
		<br>
		<br>
		<br>

		<div class="dash-board" style="margin-left: 150px;">
			<div class="detail-form" style="width: 400px; float: left; margin-right: 150px;">
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

					<div class="text-center">
						<a href='list' class="btn btn-outline-dark">목록</a><br>
					</div>

				</form>
			</div>

			<div class="comment-form" style="width: 400px; float: left;">
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
												<td>
													<a href='../boardcomment/delete?no=${comment.no}&boardNo=${board.no}'>🗑️</a>
												</td>
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
									<button type='submit' class="btn btn-outline-dark" style="margin-left: 120px">댓글 쓰기</button>
								</form>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!-- .comment-form -->
			<div style="clear: left"></div>
		</div>
		<!-- .dash-board -->
	</div>
	<!-- .main-container -->
</div>
<!-- .container -->


