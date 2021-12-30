<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set scope="page" var="contextRoot" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${contextRoot}/css/theme_list.css">

<div class="container">
	<div class="main-container">

		<br>
		<h1 style="text-align: center;">내가 좋아하는 테마 보기</h1>
		<br><br>
		<h3 style="text-align: center;">유저 테마</h3>
		<br>
		<ul class="theme-list">
			<c:forEach items="${themeList}" var="theme">
				<a class="list-container" href="../place/list?no=${theme.no}">
					<li>
						<div class="content">
							<div class="icon">${theme.emoji}</div>
							<div class="theme-title">${theme.title}</div>
						</div> <!-- .content -->
				</li>
				</a>
				<a href='delete?themeNo=${theme.no}'>❌</a>
			</c:forEach>
			<c:forEach begin="0" end="${3-(fn:length(themeList)%3)-1}">
				<a class="list-container" style="visibility: hidden;">
					<li>
						<div class="content">
							<div class="icon">${theme.no}</div>
							<div class="theme-title">${theme.title}</div>
						</div> <!-- .content -->
				</li>
				</a>
			</c:forEach>
		</ul>
		
		<h3 style="text-align: center;">참여 테마</h3>
		<br>
		<ul class="theme-list">
			<c:forEach items="${shareThemeList}" var="theme">
				<a class="list-container" href="../place/list?no=${theme.no}">
					<li>
						<div class="content">
							<div class="icon">${theme.emoji}</div>
							<div class="theme-title">${theme.title}</div>
						</div> <!-- .content -->
				</li>
				</a>
				<a href='delete?themeNo=${theme.no}'>❌</a>
			</c:forEach>
			<c:forEach begin="0" end="${3-(fn:length(shareThemeList)%3)-1}">
				<a class="list-container" style="visibility: hidden;">
					<li>
						<div class="content">
							<div class="icon">${theme.no}</div>
							<div class="theme-title">${theme.title}</div>
						</div> <!-- .content -->
				</li>
				</a>
			</c:forEach>
		</ul>
		<br><br><br><br>

	</div>
	<!-- .main-container -->
</div>
<!-- .container -->