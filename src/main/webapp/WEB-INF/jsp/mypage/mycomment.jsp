<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<div class="container">
	<h1>댓글 단 글</h1>
	<c:forEach items="${myCommentList }" var="myComment">
	<div class="mystudy_Box form-control">
		<h1>${myComment.content}</h1>
	</div>
	</c:forEach>
</div>