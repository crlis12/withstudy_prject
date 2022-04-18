<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
	<!-- 지도를 표시할 div 입니다 -->
	<div class="d-flex justify-content-center mt-3">
		<div id="map" style="width:50%;height:350px;"></div>
	</div>
	<div class="d-flex justify-content-end">
		<button type="button" class="btn btn-lg btn-primary" id="getMyPositionBtn" >나의 현재 위치</button>
	</div>
	<button type="button" class="btn btn-lg btn-primary" id="cafe" >현재 지도에 있는 주변 카페 찾기</button>
	<hr>
	<!-- 글쓰기  -->
	<div class="d-flex justify-content-between mb-3">
		<div>
			<button type="button" class="btn btn-info"><a href="/study/study_create_view" class="text-white">글쓰기</a></button>
			
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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e9de3d5fc52b64f13d9c024aad18e8ec&libraries=services"></script>

<script>
$(document).ready(function(){
	// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
	var infowindow = new kakao.maps.InfoWindow({zIndex:1});

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    }; 

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);
	
	// 주변 카페 나타내기
	$("#cafe").on('click',function(){
		// 장소 검색 객체를 생성합니다
		var ps = new kakao.maps.services.Places(map); 
		
		// 카테고리로 은행을 검색합니다
		ps.categorySearch('CE7', placesSearchCB, {useMapBounds:true}); 

		// 키워드 검색 완료 시 호출되는 콜백함수 입니다
		function placesSearchCB (data, status, pagination) {
		    if (status === kakao.maps.services.Status.OK) {
		        for (var i=0; i<data.length; i++) {
		            displayMarker(data[i]);    
		        }       
		    }
		}

		// 지도에 마커를 표시하는 함수입니다
		function displayMarker(place) {
		    // 마커를 생성하고 지도에 표시합니다
		    var marker = new kakao.maps.Marker({
		        map: map,
		        position: new kakao.maps.LatLng(place.y, place.x)
		    });
		    marker.setMap(null);
	    	marker.setMap(map);

		    // 마커에 클릭이벤트를 등록합니다
		    kakao.maps.event.addListener(marker, 'click', function() {
		        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
		        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
		        infowindow.open(map, marker);
		    });
		}
	});
	
	$("#getMyPositionBtn").on('click', function(){
		
		
		
		//나의 현재 위치
		function locationLoadSuccess(pos){
		    // 현재 위치 받아오기
			var currentPos = new kakao.maps.LatLng(pos.coords.latitude,pos.coords.longitude);
		    
			console.log(currentPos)
		    // 지도 이동(기존 위치와 가깝다면 부드럽게 이동)
		    map.panTo(currentPos);

		    // 마커 생성
		    var marker = new kakao.maps.Marker({
		        position: currentPos
		    });
		    
		    var infowindow = new kakao.maps.InfoWindow({
			    content : '<div style="padding:4px" class="text-center">나의 현재 위치</div>' // 인포윈도우에 표시할 내용
			});

			// 인포윈도우를 지도에 표시한다
			infowindow.open(map, marker);

		    // 기존에 마커가 있다면 제거
		    marker.setMap(null);
		    marker.setMap(map);
		};
		
		function locationLoadError(pos){
		    alert('위치 정보를 가져오는데 실패했습니다.');
		};
		navigator.geolocation.getCurrentPosition(locationLoadSuccess,locationLoadError);
	});
	
});
 
</script>


