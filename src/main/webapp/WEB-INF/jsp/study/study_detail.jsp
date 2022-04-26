<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <div class="study_detail_box">
    	<div class="d-flex justify-content-between mt-3">
    		<h1 class="font-weight-bold">${study.title }</h1>
    		<!-- 스크랩 박스 -->
    		<div class="d-flex align-items-center">
	    		<span class="mr-2">스크랩</span>
	    		<!-- 스크랩 버튼 비활성화 -->
	    		<img alt="scrap1" src="/static/images/not_scrap.png" width="30px" height="30px">
	    		<!-- 스크랩 버튼 활성화 -->
	    		<img alt="scrap2" src="/static/images/scrap.jpg" width="25px" height="25px">
	    	</div>
    	</div>
    	<div class="d-flex justify-content-between">
    		<span class="font-weight-bold">
    			<fmt:formatDate value="${study.createdAt}" pattern="yyyy/MM/dd HH:mm" />
    		</span>
    		<span class="font-weight-bold">
    			<span>
    				마감일:
    				<fmt:parseDate value="${study.deadline }" var="parseDateValue" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate value="${parseDateValue}" pattern="yyyy-MM-dd" />
    			</span>
    			<br>
   				마감까지 남은 기간:
   				<c:set var="today" value="<%=new java.util.Date()%>" />
				<!-- 현재날짜 -->
				<c:set var="date"><fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss" /></c:set>
				<fmt:parseDate value="${date}" var="date1" pattern="yyyy-MM-dd HH:mm:ss"/>
				<fmt:parseNumber value="${date1.time / (1000*60*60*24)}" integerOnly="true" var="today"></fmt:parseNumber>
				<fmt:parseDate value="${study.deadline}" var="endPlanDate" pattern="yyyy-MM-dd HH:mm:ss"/>
				<fmt:parseNumber value="${endPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="endDate"></fmt:parseNumber>
				<c:choose>
					<c:when test="${today- endDate > 0 }">
						<span class="text-danger font-weight-bold">
							D+${today - endDate}
						</span>
					</c:when>
					<c:when test="${today- endDate eq 0 }">
						<span class="text-danger font-weight-bold">D-day
						</span>
					</c:when>
					<c:when test="${today- endDate < 0 }">
						<span class="text-danger font-weight-bold">
							D${today - endDate}
						</span>
					</c:when>
				</c:choose>
    		</span>
    	</div>
    	<div class="d-flex justify-content-between mt-3">
    		<span class="font-weight-bold">인원: 1/${study.personnel }</span>
    		<button type="button" id="joinBtn"class="btn btn-info">신청하기</button>
    	</div>
    	<div class="mt-3">
    		${study.content}
    	</div>
    	<hr>
    	
    	<!-- 댓글 공간 -->
    	<div>
    		댓글 창
    	</div>
    </div>