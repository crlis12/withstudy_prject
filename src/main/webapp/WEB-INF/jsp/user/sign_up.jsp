<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div  id="sign_up_form" class="mt-3">
	<span class="sign_up_font display-3 font-weight-bold">WithStudy</span>
	<form method="post" action="/user/sign_up" id="signUpForm">
		<div class="mb-3">
			<lable for="loginId" class="font-weight-bold" >아이디</lable>
			<input type="text" id="loginId" name="loginId" class="form-control" placeholder="아이디를 입력하세요">
		</div>
		<div class="mb-3">
			<lable for="name" class="font-weight-bold">이름</lable>
			<input type="text" id="name" name="name" class="form-control" placeholder="이름을 입력하세요">
		</div>
		<div class="mb-3">
			<lable for="password" class="font-weight-bold">비밀번호</lable>
			<input type="password" id="password" name="password" class="form-control" placeholder="비밀번호를 입력하세요">
		</div>
		<div class="mb-3">
			<lable for="passwordCheck" class="font-weight-bold">비밀번호 확인</lable>
			<input type="password" id="passwordCheck" name="passwordCheck" class="form-control" placeholder="비밀번호 확인">
		</div>
		<div class="mb-3">
			<lable for="email" class="font-weight-bold">이메일</lable>
			<input type="text" id="email" name="email" class="form-control" placeholder="이메일을 입력하세요">
		</div>
		<div class="mb-3">
			<lable for="location" class="font-weight-bold">위치</lable>
			<input type="text" id="location" name="location" class="form-control" placeholder="ex)동작구">
		</div>
		<div class="d-flex justify-content-end">
			<button type="button" class="btn btn-info" id="signUpBtn">회원 가입</button>
		</div>
	</form>
</div>

<script>
	$(document).ready(function(){
		$("#signUpBtn").on('click', function(){
			let loginId = $("#loginId").val().trim();
			let name = $("#name").val().trim();
			let password = $("#password").val().trim();
			let passwordCheck = $("#passwordCheck").val().trim();
			let email = $("#email").val().trim();
			let location = $("#location").val().trim();
			
			if(loginId == ""){
				alert("아이디를 입력하세요")
				return;
			}
			
			if(name == ""){
				alert("이름을 입력하세요")
				return;
			}
			
			if(password == ""){
				alert("비밀번호를 입력하세요")
				return;
			}
			
			if(passwordCheck == ""){
				alert("비밀번호 확인을 하세요")
				return;
			}
			
			if(email == ""){
				alert("이메일을 입력하세요")
				return;
			}
			
			if(location == ""){
				alert("위치 입력하세요")
				return;
			}
				
		});
	});
</script>
