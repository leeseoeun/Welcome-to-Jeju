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
  body {
    background-color: #FDBB2D;
  }

  .theme-detail {
    float: left;
  }
  
  form {
    float: right;
  }
  
  input {
    border: none;
    border-radius: 0.25rem;
    background-color: white;
    padding: 0.375rem 0.75rem;
    margin-top: 1px;
    color: #212529;
    font-size: 1rem;
  }
  
  .place-search, .place {
    border: none;
    border-radius: 0.25rem;
    background-color: white;
    padding: 0.375rem 0.75rem;
    color: #212529;
    font-size: 1rem;
    text-align: center;
  }
  
  .place-list {
    position: absolute;
    float: left;
  }
  
  .place {
    border: 1px solid #212529;
    background-color: transparent;
  }
  
  #map {
    /* position: relative; */
    float: right;
    border-radius: 0.25rem;
  }
</style>
</head>

<body>
<br>

<div class="theme-detail">
  <p>
    <button class="btn btn-outline-dark" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
    🔍 ${theme.title} 상세 보기
    </button>
  </p>
  <div class="collapse" id="collapseExample">
    <div class="card card-body" style="background-color:#FEFEFE; z-index:2">
      <input id='f-no' type='hidden' name='no' value='${theme.no}'><br>
      
      <label for='f-title'>제목
        <a href='../likedtheme/add?themeNo=${theme.no}&userNo=${loginUser.no}'>💗</a>
      </label>
      <input id='f-title' type='text' name='title' value='${theme.title}' readonly><br>
      
      <label for='f-nickname'>닉네임
        <a href='../likeduser/add?userNo=${theme.owner.no}&themeNo=${theme.no}'>💗</a>
      </label>
      <input id='f-nickname' type='text' name='nickname' value='${theme.owner.nickname}' readonly><br>
      
      <label for='f-category'>카테고리</label>
      <input id='f-category' type='text' name='category' value='${theme.category.name}' readonly><br>
    
      <button type="button" class="btn btn-outline-dark" onclick="history.back();">목록</button>
    </div>
  </div>
</div>  <!-- .theme-detail -->

<form action="search">
  <input id="f-no" type="hidden" name="no" value="${theme.no}">
	<input id="f-place" type="text" name="keyword" class="place-search">
	<a href="search?no=${theme.no}&keyword=" class="btn btn-outline-dark">🎨 장소 등록하기</a>
</form>

<br><br><br>

<div class="place-list">
  <c:if test="${not empty placeList}">
  <div>
	  <c:forEach items="${placeList}" var="place">
	    <div class="place" style="z-index:1;">
	      <a href="detail?no=${theme.no}&id=${place.id}">
          ${place.place_name}<br>
          ${fn:split(place.address_name, ',')[0]}<br>
        </a>
      </div>
      <br>
    </c:forEach>
  </div>
  </c:if>
  
  <c:if test="${empty placeList}">
  </c:if>
</div>  <!-- .place-list -->

<div id="map" style="width:75%; height:480px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=10e27bbc088ef2c82002c09d3c881402&libraries=services"></script>

<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div
mapOption = {
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심 좌표
    level: 10 // 지도의 확대 레벨
};  
   
//지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

//장소 목록
var arr = new Array();
<c:forEach items="${placeList}" var="place">
    var placeMap = new Map();
    var originLocation = "${place.address_name}";
    var editLocation = originLocation.split(",")[0];
    
    var placeMap = new Map(); // Map으로 초기화시킨 객체는 iterable 객체이다.
    placeMap.set("no", "${place.id}");
    placeMap.set("name", "${place.place_name}");
    placeMap.set("location", editLocation);
    
    arr.push(placeMap);
</c:forEach>

//좌표 평균
const average = array => array.reduce( ( p, c ) => p + c, 0 ) / array.length;
const result = average( arr );

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
    map.setCenter(arr[result].get("latlng"));
    });
}
</script>

<div style="clear:left"></div>

</body>
</html>