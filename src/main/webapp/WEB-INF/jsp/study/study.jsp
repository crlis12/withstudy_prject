<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 지도를 표시할 div 입니다 -->
<div class="d-flex justify-content-center mt-3">
	<div id="map" style="width:30%;height:350px;"></div>
</div>




<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e9de3d5fc52b64f13d9c024aad18e8ec"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 
</script>


