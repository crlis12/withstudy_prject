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
		<ul>
	<li onclick="kakaoLogin();">
      <a href="javascript:void(0)">
          <span>카카오 로그인</span>
      </a>
	</li>
	<li onclick="kakaoLogout();">
      <a href="javascript:void(0)">
          <span>카카오 로그아웃</span>
      </a>
	</li>
</ul>
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
					<button type="button" class="btn btn-block btn-primary" id="signInBtn">로그인</button>
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
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('e9de3d5fc52b64f13d9c024aad18e8ec'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
        	  window.location.href = "/study/study_view"
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>

<script>
	$(document).ready(function(){
		$("#signInBtn").on('click', function(e){
			e.preventDefault();
			
			let loginId = $("#loginId").val().trim();
			let password = $("#password").val().trim();
			
			if(loginId == ""){
				alert("아이디를 입력해주세요");
				return;
			}
			
			if(password == ""){
				alert("비밀번호를 입력해주세요");
				return;
			}
		
			let url = $("#signInForm").attr("action");
			let params = $("#signInForm").serialize();
		
			$.post(url, params)
			.done(function(data){
				if(data.result == "success"){
					window.location.href = "/study/study_view";
				}
				if(data.result == "error") {
					alert(data.errorMessage);
					window.location.reload();
				}
			});	
		});
	});
</script>
</html>