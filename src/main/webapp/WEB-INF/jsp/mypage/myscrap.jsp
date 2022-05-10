<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<div class="d-flex">   
	<div class="d-flex">
		<nav>
			<div class="mypage_list mt-5">
				<h2 class="font-weight-bold">마이페이지</h2>
				<a href="/user/mypage/myinfo_view" class="text-dark font-weigt-bold">내 정보</a>
				<a href="/user/mypage/mystudy_view" class="text-dark font-weigt-bold">내가 쓴 글</a>
				<a href="/user/mypage/mycomment_view" class="text-dark font-weigt-bold">댓글 단글</a>
				<a href="/user/mypage/myscrap_view" class="text-dark font-weigt-bold">스크랩</a>
			</div>
		</nav>
	</div>
	<div class="container">
		<h2>스크랩</h2>
		<!-- 스크랩 글 반복 -->
		<c:forEach items="${scrapViewList}" var="scrapView">
		<a href="/study/study_detail_view?studyId=${scrapView.study.id}" class="text-dark">
			<div class="mystudy_Box d-flex justify-content-between">
				<h1 class="font-weight-bold">${scrapView.study.title}</h1>
				<h5 class="font-weight-bold"> 마감일:
					<fmt:parseDate value="${scrapView.study.deadline }" var="parseDateValue" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate value="${parseDateValue}" pattern="yyyy-MM-dd" />
				</h5>
			</div>
		</a>
		</c:forEach>
	</div>
</div>