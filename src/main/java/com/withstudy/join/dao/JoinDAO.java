package com.withstudy.join.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.withstudy.join.model.Join;

@Repository
public interface JoinDAO {

	public Join selectJoinUser(
			@Param("userId") Integer userId,
			@Param("studyId") int studyId);
	
	public int selectJoinByUserIdOrStudyId(
			@Param("userId") Integer userId,
			@Param("studyId") int studyId);
	
	public int selectJoinByStudyId(int studyId);
	
	public int insertJoin(
			@Param("userId") Integer userId,
			@Param("studyId") int studyId);
	
	public int deleteJoin(
			@Param("userId") Integer userId,
			@Param("studyId") int studyId);
}
