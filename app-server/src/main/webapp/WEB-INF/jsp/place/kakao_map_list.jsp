<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <style>
  html {
    height: 100%;
  }
  h3 {
    text-align: center;
    font-weight: bolder; 
  }
  a {
   text-decoration:none;
  }
  body {
    overflow: hidden;
    width: 100%;
    height: 100%;
  }
  #search {
    text-align: center;
    padding: 20px;
  }
  .form-select {
    display: inline-block;
  }
  .template-wrap {
    --desktopHeaderContentHeight: 60px;
    --headerVerticalPadding: 10px;
    --desktopNavHeight: calc(var(--headerVerticalPadding) + var(--desktopHeaderContentHeight) + var(--headerVerticalPadding));
    --desktopTopBarHeight: 20.80px;
    --desktopTopBarPadding: 20px;
    --desktopTopBar: calc(var(--desktopTopBarHeight) + var(--desktopTopBarPadding) + var(--desktopTopBarPadding));
     height: calc(100% - var(--desktopNavHeight) - var(--desktopTopBar));
  }
  .template-wrap .template-content {
    width: 100%;
    height: 100%;
  }
  .c-content {
    display: flex;
    --desktopSearchBarHeight: 38px;
    --desktopSearchBarPadding: 20px;
    --desktopSearchBar: calc(var(--desktopSearchBarHeight) + var(--desktopSearchBarPadding) + var(--desktopSearchBarPadding));
    height: calc(100% - var(--desktopSearchBar));
  }
  #content {
    margin-left: 20px;
    width: 722px;
    float: left;
    overflow-y: scroll;
    overflow-x:hidden;
  }
  .col {
    width: 355px;
  }
  .card {
    height: 381px;
  }
  footer {
    display: none;
  }
  .badge {
    color: slategray;
  }
  #main {
    height: 100%;
  }
  
  .themedetail {
    margin : 30px;
    float : right;
    }
  </style>
</head>
<body>

<div class="themedetail">
  <p>
    <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
      ${theme.title} 상세 보기 🔍
    </button>
  </p>
  <div class="collapse" id="collapseExample">
    <div class="card card-body">
      <form action='update'>
      <label for='f-no'>번호</label>
      <input id='f-no' type='text' name='no' value='${theme.no}' readonly><br>
      
      <label for='f-title'>제목</label>
      <input id='f-title' type='text' name='title' value='${theme.title}' readonly>
      <a href='../likedtheme/add?themeNo=${theme.no}&userNo=${loginUser.no}'> 🤍</a><br>
      <a href='../report/themeform?no=${theme.no}'> 🚨</a><br>
      
      <label for='f-nickname'>닉네임</label>
      <input id='f-nickname' type='text' name='nickname' value='${theme.owner.nickname}' readonly> 
      <a href='../likeduser/add?userNo=${theme.owner.no}&themeNo=${theme.no}'>🤍</a><br>
      <a href='../report/userform?no=${theme.no}'> 🚨</a><br>
      
      <label for='f-category'>카테고리</label>
      <input id='f-category' type='text' name='category' value='${theme.category.name}' readonly><br>
      
      <label for='f-hashtags'>해시태그</label>
      <input id='f-hashtags' type='text' name='hashtags' value='${theme.hashtags}' readonly><br>
    
      <a href='../'>[목록]</a>
      </form>
    </div>
  </div>
</div>  <!-- .themedetail -->

  <div id="search">
  <div style="float:left; font-size:13.5px; padding-top: 5px; display: none;"><span>최신순</span> | <span>평점순</span></div>
    <form action="search" class="row g-3 justify-content-center">
    <div class="col-auto">
      <select name="where" style="line-height: normal; font-size: 13.5px;" class="form-select form-select-sm">
        <option value="1">지역</option>
        <option value="2">이름</option>
      </select>
    </div>
    <div class="col-auto">
      <input type="text" name="keyword" style="line-height: 13.5px; font-size: 13.5px;" class="form-control form-control-sm">
    </div>
    <div class="col-auto">
      <button class="btn btn-outline-dark" style="line-height: 13.5px; font-size: 13.5px; margin-bottom: 4px;">검색</button>
    </div>
    </form>
  </div>

<div class="c-content">
<div id="content">
<c:if test='${not empty placeList}'>
    <div class="row row-cols-1 row-cols-md-3 g-4">
    <c:forEach items="${placeList}" var="place">
      <div class="col">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title" style="font-size:14px; font-weight: bold;">
              <a href='detail?no=${place.id}'>${place.place_name}</a>
            </h5>
            <p style="font-size:14px;">
            ${fn:split(place.address_name, ',')[0]}<br>
            </p>
          </div>
        </div>
      </div>
    </c:forEach>
    </div>
  </c:if>
<c:if test='${empty placeList}'>
   검색 결과가 존재하지 않습니다.<br><br>  
</c:if>
</div>

<div id="map" style="width:calc(100% - 722px - 38px);"></div>
  
</div>  

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=19b698969a5fbbf08d3bddab4e1ceacc&libraries=services"></script>
<script>
   var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
   mapOption = {
       center: new kakao.maps.LatLng(37.498004414546934, 127.02770621963765), // 지도의 중심좌표
       level: 3 // 지도의 확대 레벨
   };  
   
   //지도를 생성합니다    
   var map = new kakao.maps.Map(mapContainer, mapOption); 
   
   // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
   var mapTypeControl = new kakao.maps.MapTypeControl();
   // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
   // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
   map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
   // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
   var zoomControl = new kakao.maps.ZoomControl();
   map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
   
   //주소-좌표 변환 객체를 생성합니다
   var geocoder = new kakao.maps.services.Geocoder();
   
   // 카페 주소 리스트
   var arr = new Array();
   <c:forEach items="${placeList}" var="place">
     var cafeMap = new Map();
   
     var originLocation = "${place.address_name}";
     var editLocation = originLocation.split(",")[0];
   
     var cafeMap = new Map(); // Map으로 초기화시킨 객체는 iterable 객체이다. 
     cafeMap.set("name", "${place.place_name}");
     cafeMap.set("no", "${place.id}");
     cafeMap.set("location", editLocation);
     
     arr.push(cafeMap);
   </c:forEach>
   
   for (let i = 0; i < arr.length; i++) {
   
     //주소로 좌표를 검색합니다
     geocoder.addressSearch(arr[i].get("location"), function(result, status) {
   
       // 정상적으로 검색이 완료됐으면 
       if (status === kakao.maps.services.Status.OK) {
   
        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
   
        arr[i].set("latlng", coords);
       }
       
       // 마커를 생성합니다
       var marker = new kakao.maps.Marker({
           map: map, // 마커를 표시할 지도
           position: arr[i].get("latlng") // 마커를 표시할 위치
       });
       
        // 인포윈도우로 장소에 대한 설명을 표시합니다
       var infowindow = new kakao.maps.InfoWindow({
           content: '<div style="width:150px;text-align:center;padding:6px 0;font-size:14px;">'+arr[i].get("name")+'</div>'
       });
       infowindow.open(map, marker);
       // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
       map.setCenter(arr[0].get("latlng"));
     });
     
   }
</script>