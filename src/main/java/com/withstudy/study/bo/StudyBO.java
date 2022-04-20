package com.withstudy.study.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withstudy.study.dao.StudyDAO;

@Service
public class StudyBO {

	
	@Autowired
	private StudyDAO studyDAO;
	
	public int addStudy(int userId, int hostUserId, String title, int personnel,
			String deadline, String location, String content) {
		
		return studyDAO.insertStudy(userId, hostUserId, title, personnel, deadline, location, content); 
	}
}
