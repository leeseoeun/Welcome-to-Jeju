<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${contextRoot}/css/user_list.css">

<div class="container">
	<div class="main-container">

		<br>
		<h1 style="text-align: center;">내가 좋아하는 유저 보기</h1>
		<br>

		<div class="dash-board">
			<div class="hot-curators">
				<div class="title"></div>
				<ul class="hot-curators-list" style="margin-left: 45px;">
					<c:forEach items="${userList}" var="user">
						<li><a href="../theme/userlist?no=${user.no}" class="content">
								<div class="icon">${user.emoji}</div>
								<div class="curator-name">${user.nickname}</div>
						</a></li>
						<a href='delete?userNo=${user.no}' style="margin-left: -18px; margin-right: 12px;">❌</a>
					</c:forEach>
					
					<c:forEach begin="0" end="${3-(fn:length(userList)%3)-1}">
        <a class="list-container" style="visibility: hidden;">
          <li>
            <div class="content">
              <div class="icon">${user.emoji}</div>
              <div class="curator-name">${user.nickname}</div>
            </div> <!-- .content -->
        </li>
        </a>
      </c:forEach>
				</ul>
				<br><br><br><br>
			</div>
			<!-- .hot-curators -->
		</div>
		<!-- .dash-board -->

	</div>
	<!-- .main-container -->
</div>
<!-- .container -->