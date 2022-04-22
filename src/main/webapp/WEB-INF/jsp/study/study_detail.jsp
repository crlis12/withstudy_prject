<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="study_detail_box">
    	<div class="d-flex justify-content-between mt-3">
    		<h1 class="font-weight-bold">스터디 제목 자리</h1>
    		<span class="">스크랩</span>
    	</div>
    	<div class="d-flex justify-content-between">
    		<span class="font-weight-bold">
    			글 올린 시간 ${study.createdAt }
    		</span>
    		<span class="font-weight-bold">
    			<span>마감일:</span>
    			<span class="text-danger font-weight-bold">남은 기간 D-</span>
    		</span>
    	</div>
    	<div class="d-flex justify-content-between mt-3">
    		<span class="font-weight-bold">인원:</span>
    		<button type="button" id="joinBtn"class="btn btn-info">신청하기</button>
    	</div>
    	<div class="mt-3">
    		스터디 모임 글 내용 공간
    	</div>
    	<hr>
    	
    	<!-- 댓글 공간 -->
    	<div>
    		댓글 창
    	</div>
    </div>