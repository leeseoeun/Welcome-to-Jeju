<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set scope="page" var="contextRoot" value="${pageContext.servletContext.contextPath}" />

<!-- 전체 테마 -->
<c:set scope="page" var="contextRoot2" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<title>제주 옵서예</title>

<jsp:include page="../template_head.jsp"/>
<link rel="stylesheet" href="${contextRoot}/css/home.css?ver=1">
<script defer src="${contextRoot}/javascript/home.js"></script>

<!-- 전체 테마 -->
<link rel="stylesheet" href="${contextRoot2}/css/theme_list.css">

<style>
.owl-dots {
  display: none;
}

.owl-item {
}

.customPrevBtn, .customNextBtn {
	background: none;
	border: none;
	color: #999999;
	font-size: 20px;
	font-weight: bold;
}

@media (max-width: 768px) {
  .pbPrevBtn, .pbNextBtn {
    display: none;
  }
}

.user-share-themelist {
  margin-left: 110px;
}
</style>

<body>
  <main>
		<jsp:include page="../header.jsp" />
		<jsp:include page="../sideBar.jsp" />
		
		<!-- 참여 테마 기준 -->
		<div class="theme-slide">
			<button class="left">
				<i class="fas fa-angle-left"></i>
			</button>
			<ul class="slide-theme-content">
				<c:forEach items="${shareThemeList}" var="theme">
					<li>
            <a href="place/list?no=${theme.no}" class="slide-theme-content-item">
							<div class="icon">${theme.emoji}</div>
							<div class="theme-title">${theme.title}</div>
            </a>
				  </li>
				</c:forEach>
			</ul>
			<button class="right">
				<i class="fas fa-angle-right"></i>
			</button>
		</div>
		
		<!-- 검색 -->
		<form id="search-form" action="${contextRoot}/app/search/main">
			<div class="search-container">
				<input type="text" name="keyword" id="search-bar">
				<button class="search-icon">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		
    <!-- 유저 테마 순위 -->
		<div class="dash-board">
      <div class="hot-theme">
        <div class="title">
          <span>🎖️ 유저 테마 순위</span>
          <!-- <div class="sub">인기 있는 테마</div> -->
        </div>
        <ul class="hot-theme-list owl-carousel">
          <c:forEach items="${publicThemeRanking10}" var="theme">
            <li>
              <a href="place/list?no=${theme.no}" class="content">
                <div class="icon">${theme.emoji}</div>
                <div class="theme-content">
	                <div class="theme-title">${theme.title}</div>
                </div>
              </a>
            </li>
          </c:forEach>
        </ul>
      </div>  <!-- .hot-theme -->
    </div>  <!-- .dash-board -->
    
        <!--참여 테마 순위 -->
    <div class="dash-board">
      <div class="hot-theme">
        <div class="title">
          <span>🎖️ 참여 테마 순위</span>
          <!-- <div class="sub">인기 있는 테마</div> -->
        </div>
        <ul class="hot-theme-list owl-carousel">
          <c:forEach items="${shareThemeRanking10}" var="theme">
            <li>
              <a href="place/list?no=${theme.no}" class="content">
                <div class="icon">${theme.emoji}</div>
                <div class="theme-content">
                  <div class="theme-title">${theme.title}</div>
                </div>
              </a>
            </li>
          </c:forEach>
        </ul>
      </div>  <!-- .hot-theme -->
    </div>  <!-- .dash-board -->
      
    <!-- 유저 순위 -->
    <div class="dash-board">
			<div class="hot-curators">
				<div class="title">
					<span>🏆 유저 순위</span>
					<!-- <div class="sub">인기 있는 유저</div> -->
				</div>
				<ul class="hot-curators-list .owl-carousel2">
					<c:forEach items="${userRanking10}" var="user">
						<li>
						  <a href="theme/userlist?no=${user.no}" class="content">
								<div class="icon">${user.emoji}</div>
								<div class="curator-name">${user.nickname}</div>
								<%-- <div class="theme-count">${user.registeredDate}</div> --%>
						  </a>
						</li>
					</c:forEach>
				</ul>
			</div>  <!-- .hot-curators -->
    </div>  <!-- .dash-board -->
    
    <br><br><br><br>
    
    <!-- 장소 순위 -->
    <div class="hot-place">
      <div class="title">
        <span>🏅 장소 순위</span>
        <!-- <div class="sub">인기 있는 장소</div> -->
      </div>
      <ul class="hot-place-list owl-carousel">
        <c:forEach items="${placeRaking10}" var="place">
          <li>
            <a href="#" class="content">
              <div class="desc">
                <div class="name">${place.place_name}</div>
                <div class="address">${place.address_name}</div>
              </div>
              <div class="themes">
                <c:forEach items="${place.themeList}" var="placeBelongTheme"
                  begin="0" end="2">
                  <div class="theme">${placeBelongTheme.title}</div>
                </c:forEach>
              </div>  <!-- .themes -->
            </a>
          </li>
        </c:forEach>
      </ul>
    </div>  <!-- .hot-place -->
    
    <!-- 최근 유저 테마 -->
    <div class="dash-board">
      <div class="hot-theme">
        <div class="title">
          <span>🌠 최근 유저 테마</span>
          <!-- <div class="sub">최근 테마 목록</div> -->
        </div>
        <ul class="hot-theme-list owl-carousel">
          <c:forEach items="${newPublicTheme10}" var="theme">
            <li>
              <a href="place/list?no=${theme.no}" class="content">
                <div class="icon">${theme.emoji}</div>
                <div class="theme-content">
                  <div class="theme-title">${theme.title}</div>
                </div>
              </a>
            </li>
          </c:forEach>
        </ul>
      </div>  <!-- .hot-theme -->
    </div>  <!-- .dash-board -->
    
    <!-- 최근 참여 테마 -->
    <div class="dash-board">
      <div class="hot-theme">
        <div class="title">
          <span>🌠 최근 참여 테마</span>
          <!-- <div class="sub">최근 테마 목록</div> -->
        </div>
        <ul class="hot-theme-list owl-carousel">
          <c:forEach items="${newShareTheme10}" var="theme">
            <li>
              <a href="place/list?no=${theme.no}" class="content">
                <div class="icon">${theme.emoji}</div>
                <div class="theme-content">
                  <div class="theme-title">${theme.title}</div>
                </div>
              </a>
            </li>
          </c:forEach>
        </ul>
      </div>  <!-- .hot-theme -->
    </div>  <!-- .dash-board -->
    
    <!-- 전체 테마 -->
    <div class="dash-board">
      <div class="hot-theme">
        <div class="title">
          <span>🌟 전체 테마</span>
        </div>
      </div>  <!-- .hot-theme -->
    </div>  <!-- .dash-board -->
    
    <!-- 유저 테마 -->
    <div class="container">
      <div class="main-container">
        <div class="user-share-themelist">유저 테마</div>
      <ul class="theme-list">
      <c:forEach items="${publicThemeList}" var="theme">
      <a class="list-container" href="../place/list?no=${theme.no}"
      begin="0" end="${3-(fn:length(publicThemeList)%3)-1}">
        <li>
          <div class="content">
	          <div class="icon">${theme.emoji}</div>
	          <div class="theme-title">${theme.title}</div>
	          <div class="theme-count">${theme.owner.nickname}</div>
          </div>  <!-- .content -->
        </li>
      </a>
      </c:forEach>
      </ul>
    <!-- 참여 테마 -->
        <div class="user-share-themelist">참여 테마</div>
      <ul class="theme-list">
      <c:forEach items="${shareThemeList}" var="theme"
      begin="0" end="${3-(fn:length(shareThemeList)%3)-1}">
      <a class="list-container" href="../place/list?no=${theme.no}">
        <li>
          <div class="content">
	          <div class="icon">${theme.emoji}</div>
	          <div class="theme-title">${theme.title}</div>
          </div>  <!-- .content -->
        </li>
      </a>
      </c:forEach>
      </ul>
      </div>  <!-- .main-container -->
    </div>  <!-- .container -->
	</main>

  <footer>
    <div class="footer-link">
      <a href="#">사용자 피드백 🌴 신고 및 의견은 여기에</a>
    </div>
		<div>
		  <a href="#">개인 정보 처리 방침</a>
		</div>
		<br>
	</footer>

	<script>
	$(document).ready(function() {
		var owl = $('.owl-carousel');
		
		owl.owlCarousel({
			items: 3,  // 한번에 보여 줄 아이템 수
			loop: true,  // 반복 여부
			margin: 35,  // 오른쪽 간격
			autoplay: false, // 자동 재생 여부
			autoplayTimeout: 1800, // 재생 간격
			autoplayHoverPause: true // 마우스 hover 시 멈출지 여부
		});
		
		$('.customNextBtn').click(function() {
			owl.trigger('next.owl.carousel');
		})
		
		$('.customPrevBtn').click(function() {
			owl.trigger('prev.owl.carousel', [ 300 ]);
		})
	});
		
	$(document).ready(function() {
		var owl = $('.owl-carousel2');
		
		owl.owlCarousel({
			items: 7,  // 한번에 보여 줄 아이템 수
			loop: true,  // 반복 여부
			margin: 35,  // 오른쪽 간격
			autoplay: false, // 자동 재생 여부
			autoplayTimeout: 1800, // 재생 간격
			autoplayHoverPause: true // 마우스 hover 시 멈출지 여부
		});
		
		$('.customNextBtn').click(function() {
			owl.trigger('next.owl.carousel');
		})
		
		$('.customPrevBtn').click(function() {
			owl.trigger('prev.owl.carousel', [ 300 ]);
		})
	});
	</script>

</body>
</html>
