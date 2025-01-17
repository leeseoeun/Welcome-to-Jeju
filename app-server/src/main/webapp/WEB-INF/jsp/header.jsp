<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set scope="page" var="contextRoot" value="${pageContext.servletContext.contextPath}"/>

<header>
  <a class="logo" href="${contextRoot}/app/home">
    <button type="submit" class="login">
      <span class="title">🌊 제주 옵서예</span>
    </button>
  </a>
  
  <div class="logout-box">
    <c:if test="${empty loginUser}">
    <form class="login_form" action='${contextRoot}/app/auth/loginform'>
      <button type="submit" class="login">로그인</button>
    </form>
    </c:if>
    
    <c:if test="${!empty loginUser}">
      ${loginUser.emoji}&nbsp;${loginUser.nickname}
    </c:if>
    
    <button class="side-menu">
      <i class="fas fa-align-justify"></i>
    </button>
  </div>  <!-- .logout-box -->
</header>