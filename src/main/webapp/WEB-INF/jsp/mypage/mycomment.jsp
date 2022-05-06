<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<div class="">
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
		<div class="mypage_commentBox">
			<h2 class="font-weight-bold ml-5">댓글 단 글</h2>
			<div class="commentBox_header">
				<div class="text-center">
					<span class="commentBox_content">스터디 제목</span>
					<span class="commentBox_content">댓글</span>
					<span class="commentBox_content">작성일</span>
				</div>
			</div>
			
			<c:forEach items="${myCommentList }" var="myComment">
			<a href="/study/study_detail_view?studyId=${myComment.studyId}" class="text-dark">
			<div class="commentBox_comment_list">
				<div class="commentBox_content_title text-center ">
					<span>${myComment.content}</span>
				</div>
				<div class="commentBox_content_comment text-center">
					${myComment.content}
				</div>
				<div class="commentBox_content_title text-center">
					<fmt:formatDate value="${myComment.createdAt}" pattern="yyyy/MM/dd HH:mm" />
				</div>
			</div>
			</a>
			</c:forEach>
		</div>
	</div>
</div>