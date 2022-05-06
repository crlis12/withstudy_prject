package com.withstudy.scrap.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.withstudy.scrap.model.Scrap;

@Repository
public interface ScrapDAO {

	public List<Scrap> selectScrapByStudyId(Integer userId);
	
	// 스크랩 데이터
	public int selectScrapByStudyIdOrUserId(
			@Param("studyId") int studyId,
			@Param("userId") Integer userId);
	
	// 스크랩 저장
	public void insertScrap(
			@Param("studyId") int studyId,
			@Param("userId") Integer userId);
	
	// 스크랩 삭제
	public void deleteScrap(
			@Param("studyId") int studyId,
			@Param("userId") Integer userId);
}
