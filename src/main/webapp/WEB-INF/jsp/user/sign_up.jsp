<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div  id="sign_up_form" class="mt-3">
	<span class="sign_up_font display-3 font-weight-bold">WithStudy</span>
	<form method="post" action="/user/sign_up" id="signUpForm">
		<div class="mb-3">
			<lable for="loginId" class="font-weight-bold" >아이디</lable>
			<div class="d-flex">
				<input type="text" id="loginId" name="loginId" class="form-control col-8" placeholder="아이디를 입력하세요">
				<button type="button" id="idCheck" class="btn btn-success ml-2">중복 확인</button>
			</div>
			<div>
				<span class="text-danger d-none" id="idCheckDuplicated">이미 있는 ID입니다</span>
				<span class="text-success d-none" id="idCheckOk">사용 가능한 ID입니다.</span>
			</div>
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
		//아이디 중복 검사
		$("#idCheck").on('click', function(){
			let loginId = $("#loginId").val().trim();
			
			if(loginId == ""){
				alert("아이디를 입력해주세요");
				return;
			}
			
			$.ajax({
				url:"/user/idCheck",
				data: {"loginId": loginId},
				success: function(data) {
					if(data.result == true){
						$("#idCheckOk").addClass("d-none");
						$("#idCheckDuplicated").removeClass("d-none");
					} else{
						$("#idCheckDuplicated").addClass("d-none");
						$("#idCheckOk").removeClass("d-none");
					}
				},
				error: function(error) {
					alert("중복확인에 실패했습니다. 관리자에게 문의해 주세요.");
				}
			});
			
		});
		
		//회원가입
		$("#signUpBtn").on('click', function(){
			let loginId = $("#loginId").val().trim();
			let name = $("#name").val().trim();
			let password = $("#password").val().trim();
			let passwordCheck = $("#passwordCheck").val().trim();
			let email = $("#email").val().trim();
			let location = $("#location").val().trim();
			
			if(loginId == ""){
				alert("아이디를 입력하세요");
				return;
			}
			
			if(name == ""){
				alert("이름을 입력하세요");
				return;
			}
			
			if(password == ""){
				alert("비밀번호를 입력하세요");
				return;
			}
			
			if(passwordCheck == ""){
				alert("비밀번호 확인을 하세요");
				return;
			}
			
			if(email == ""){
				alert("이메일을 입력하세요");
				return;
			}
			
			if(location == ""){
				alert("위치 입력하세요");
				return;
			}
			
			if(password != passwordCheck){
				alert("비밀번호가 틀립니다. 비밀번호 확인을 다시 하세요");
				$("#password").val("");
				$("#passwordCheck").val("");
				return;
			}
			
			// 아이디 중복 확인을 안할 시
			if ($('#idCheckOk').hasClass('d-none') == true) {
				alert("아이디 확인을 다시 해주세요.");
				return;
			}
			
			let url = $("#signUpForm").attr("action")
			let	params = $("#signUpForm").serialize();
			
			
			$.post(url, params)
			.done(function(data){
				if(data.result == "success"){
					alert("회원가입이 완료 되었습니다. 스터디 모임을 구해보세요!!");
					location.href="/user/sign_in_view";
				} else {
					alert("회원 가입에 실패 했습니다. 관리자에게 문의해주세요");
				}
			});
		});
	});
</script>
