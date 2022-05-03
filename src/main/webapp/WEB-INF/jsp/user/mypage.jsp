<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mypage_box">
	<div class="mypage_form form-control mt-3">
		<div class="d-flex align-items-center">
			<div>
				<img alt="" src="/static/images/scrap.jpg" width="70px" height="70px">
			</div>
			<div class="ml-3 font-weight-bold">
				${userloginId}
				<br>
				${userName}
			</div>
		</div>
	</div>
	<a href="/user/mypage/myinfo_view" class="btn mypage_form mt-3 form-control">
			내 정보
	</a>
	
	<a href="/user/mypage/mystudy_view" class="btn mypage_form mt-3 form-control">
			내가 쓴 글	
	</a>
	
	<a href="#" class="btn mypage_form mt-3 form-control">
			댓글 단글		
	</a>
		
	<a href="#" class="btn mypage_form mt-3 form-control">
			스크랩		
	</a>
</div>