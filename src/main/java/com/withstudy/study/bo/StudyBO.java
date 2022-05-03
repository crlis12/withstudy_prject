package com.withstudy.study.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withstudy.study.dao.StudyDAO;
import com.withstudy.study.model.Study;

@Service
public class StudyBO {

	
	@Autowired
	private StudyDAO studyDAO;

	// select
	public List<Study> getStudyList()	{
		
		return studyDAO.selectStudyList();
	}
	
	public List<Study> getStudyByuserId(Integer userId) {
		
		return studyDAO.selectStudyByuserId(userId);
	}
	
	public Study getStudyById(int studyId) {
		return studyDAO.selectStudyById(studyId);
	}
	
	// 스터디 모임 글 생성
	public int addStudy(int userId, int hostUserId, String title, int personnel,
			String deadline, String location, String content) {
		
		return studyDAO.insertStudy(userId, hostUserId, title, personnel, deadline, location, content); 
	}
	
	
}
