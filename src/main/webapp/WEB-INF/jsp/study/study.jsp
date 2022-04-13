<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
	<!-- 지도를 표시할 div 입니다 -->
	<div class="d-flex justify-content-center mt-3">
		<div id="map" style="width:50%;height:350px;"></div>
	</div>
	<hr>
	<!-- 글쓰기  -->
	<div class="d-flex justify-content-between mb-3">
		<div>
			<button type="button" class="btn btn-info">글쓰기</button>
		</div>
		<!-- 검색 -->
		<div class="d-flex">
			<select id="" class="form-control">
				<option>전체 지역</option>
				<option>동작구</option>
				<option>강남구</option>
				<option>...</option>
			</select>
			<input id="search" type="text" name="search" class="form-control ml-3" placeholder="검색">
		</div>
	</div>
	
	<!-- 스터디 모임 -->
	<table class="table text-center">
		<thead>
			<tr>
				<th>스터디</th>
				<th>인원</th>
				<th>위치</th>
				<th>모집기간</th>
			</tr>
		</thead>
		<!-- 모임 데이터 반복 상자 -->
		<tbody>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
		</tbody>
	</table>
</div>


<!-- 지도 발급 키 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e9de3d5fc52b64f13d9c024aad18e8ec"></script>

<script>
$(document).ready(function(){
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption);
	
	
});
 
</script>


