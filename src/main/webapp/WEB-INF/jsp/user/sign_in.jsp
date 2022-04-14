<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>With Study</title>

<!-- bootstrap CDN link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<!-- 원본 제이쿼리 스크립트 가져온다(슬림 x) -->
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

	<link rel="stylesheet" type="text/css" href="/static/css/style.css">
	
</head>
<body>
	<div>
		<header class="sign_in_top text-center">
				<div class="d-flex justify-content-center align-items-center">
					<img alt="로고1" src="/static/images/logo.png" height="100px" width="300px" class="mt-5">
				</div>
				<div>
					<span class="sign_in_expain" ><b>위드스터디</b>를 통해 <br>다양한 <b>스터디 모임</b>을 구해보세요!</span>
				</div>
		</header>
		<section>
			<div class="sign_in_style mt-4">
				<form id="signInForm" method="post" action="/user/sign_in">
					<input type="text" id="loginId" name="loginId" placeholder="아이디를 입력하세요" class="form-control mb-3">
					<input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" class="form-control mb-3">
					<button type="button" class="btn btn-block btn-primary">로그인</button>
					<div class="d-flex justify-content-between align-items-center mt-3">
						<span class="font-weight-bold">회원 가입 후 원하는 스터디 모임을 구해보세요</span>
						<a class="btn btn-secondary col-3" href="/user/sign_up_view">회원가입</a>
					</div>
				</form>
			</div>
		</section>
		<footer>
			<div class="footer">
				<span>COPYRIGHT@2022 Chang Ryeol</span>
			</div>
		</footer>
	</div>
</body>
</html>