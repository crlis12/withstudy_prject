package com.withstudy.join.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withstudy.join.dao.JoinDAO;
import com.withstudy.join.model.Join;

@Service
public class JoinBO {

	@Autowired
	private JoinDAO joinDAO;

	public Join getJoinUser(Integer userId, int studyId) {
		
		return joinDAO.selectJoinUser(userId, studyId);
	}
	
	public int getJoinByUserIdOrStudyId(Integer userId, int studyId) {

		return joinDAO.selectJoinByUserIdOrStudyId(userId, studyId);
	}
	
	public int getJoinByStudyId(int studyId) {
		
		return joinDAO.selectJoinByStudyId(studyId);
	}

	public boolean existJoin(Integer userId, int studyId) {

		if (userId == null) {

			return false;
		}
		int count = joinDAO.selectJoinByUserIdOrStudyId(userId, studyId);

		if (count > 0) {
			return true;
		}

		return false;
	}
	// 스터디 신청 클릭시
	public void join(Integer userId, int studyId) {
		
		boolean existJoin = existJoin(userId, studyId);
		
		if(existJoin == false) {
			joinDAO.insertJoin(userId, studyId);
		}
		if(existJoin == true) {
			joinDAO.deleteJoin(userId, studyId);
		}
	}
	

	// 스터디 신청
	public int addJoin(Integer userId, int studyId) {

		return joinDAO.insertJoin(userId, studyId);
	}

	// 스터디 신청 삭제
	public int deleteJoin(Integer userId, int studyId) {

		return joinDAO.deleteJoin(userId, studyId);
	}
}