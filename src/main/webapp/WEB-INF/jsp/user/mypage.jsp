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
	
	<div class="mypage_form mt-3 text-center form-control">
		내정보
	</div>
	
	<div class="mypage_form mt-3 text-center form-control">
		내가 쓴글
	</div>
	
	<div class="mypage_form mt-3 text-center form-control">
		댓글 단글
	</div>
	
	<div class="mypage_form mt-3 text-center form-control">
		스크랩
	</div>
</div>