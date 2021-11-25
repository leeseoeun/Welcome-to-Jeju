<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}" />
<link rel="stylesheet" href="${contextRoot}/css/home.css?ver=1">
<link rel="stylesheet" href="${contextRoot}/css/theme_list.css">

<div class="dash-board">
	<div class="hot-curators">
		<div class="title">
			<span>🔎 '${keyword}'로 검색한 유저 목록</span>
			<div class="sub"># 유저 검색하기</div>
		</div>
		<ul class="hot-curators-list .owl-carousel2">
			<c:forEach items="${userList}" var="user">
				<li><a href="../theme/userlist?no=${user.no}" class="content">
						<div class="icon">${user.emoji}</div>
						<div class="curator-name">${user.nickname}</div>
						<div class="theme-count">${user.registeredDate}</div>
				</a></li>
			</c:forEach>
		</ul>
	</div>

	<div class="hot-theme">
		<div class="title">
			<span>🔎 '${keyword}'로 검색한 테마 목록</span>
			<div class="sub"># 테마 검색하기</div>
		</div>
		<ul class="theme-list">
			<c:forEach items="${themeList}" var="theme">
				<a class="list-container" href="../place/list?no=${theme.no}">
					<li>
						<div class="content">

							<c:if test="${!empty theme.emoji}">
								<div class="icon">${theme.emoji}</div>
							</c:if>
							<c:if test="${empty theme.emoji}">
								<div class="icon">🏄</div>
							</c:if>
							<div class="theme-title">${theme.title}</div>
							<div class="theme-count">${theme.hashtags}</div>
						</div> <!-- .content -->
				</li>
				</a>
			</c:forEach>
			<c:forEach begin="0" end="${3-(fn:length(themeList)%3)-1}">
				<a class="list-container" style="visibility: hidden;">
					<li>
						<div class="content">
							<div class="icon">${theme.no}</div>
							<div class="theme-title">${theme.title}</div>
							<div class="theme-count">#${theme.hashtags}</div>
						</div> <!-- .content -->
				</li>
				</a>
			</c:forEach>
		</ul>
	</div>

	<div class="hot-theme">
		<div class="title">
			<span>🔎 해시태그 '${keyword}'로 검색한 테마 목록</span>
			<div class="sub"># 해시태그로 검색하기</div>
		</div>
		<ul class="theme-list">
			<c:forEach items="${hashtagList}" var="theme">
				<a class="list-container" href="../place/list?no=${theme.no}">
					<li>
						<div class="content">

							<c:if test="${!empty theme.emoji}">
								<div class="icon">${theme.emoji}</div>
							</c:if>
							<c:if test="${empty theme.emoji}">
								<div class="icon">🏄</div>
							</c:if>
							<div class="theme-title">${theme.title}</div>
							<div class="theme-count">${theme.hashtags}</div>
						</div> <!-- .content -->
				</li>
				</a>
			</c:forEach>
			<c:forEach begin="0" end="${3-(fn:length(themeList)%3)-1}">
				<a class="list-container" style="visibility: hidden;">
					<li>
						<div class="content">
							<div class="icon">${theme.no}</div>
							<div class="theme-title">${theme.title}</div>
							<div class="theme-count">#${theme.hashtags}</div>
						</div> <!-- .content -->
				</li>
				</a>
			</c:forEach>
		</ul>
	</div>
</div>
