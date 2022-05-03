<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
	<h1>나의 스터디</h1>
	<c:forEach items="${myStudyList}" var="myStudy">
	<div>
		<a href="/study/study_detail_view?studyId=${myStudy.id }" >
			<div class="mystudy_Box form-control">
				<h3 class="font-weight-bold">${myStudy.title}</h3>
				<h5></h5>
			</div>
		</a>
	</div>
	</c:forEach>
	
</div>