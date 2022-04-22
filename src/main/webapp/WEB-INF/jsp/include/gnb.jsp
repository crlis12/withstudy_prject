<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="logo d-flex justify-content-between align-items-center">
	<div>
		<img alt="logo" src="/static/images/logo.png" width="150px" height="80px" class="ml-3">
		<span class="logo_font font-weight-bold"><a href="/study/study_view">WithStudy</a></span>
	</div>
	<div>
		<span class="mr-3">${userName}</span>
		<c:choose>
			<c:when test="${not empty userName}">
				<a href="/user/sign_out" class="mr-5 text-white">로그아웃</a>
			</c:when>
			<c:when test="${empty userName}">
				<a href="/user/sign_in_view" class="mr-5 text-white">로그인</a>
			</c:when>
		</c:choose>
	</div>
</div>