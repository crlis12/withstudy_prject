package com.withstudy.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.withstudy.study.model.Study;

@Repository
public interface StudyDAO {
	
	// select
	// 스터디 데이터 가져오기
	public List<Study> selectStudyList();
	
	public Study selectStudyById(int studyId);
	
	public List<Study> selectStudyByuserId(Integer userId);
	
	//insert
	// 스터디 모임 만들기
	public int insertStudy(
			@Param("userId") int userId,
			@Param("hostUserId") int hostUserId,
			@Param("title") String title,
			@Param("personnel") int personnel,
			@Param("deadline") String deadline,
			@Param("location") String location,
			@Param("content") String content);
	
}
