package com.withstudy.study.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyDAO {
	
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
