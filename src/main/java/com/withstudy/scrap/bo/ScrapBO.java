package com.withstudy.scrap.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withstudy.scrap.dao.ScrapDAO;

@Service
public class ScrapBO {
	
	@Autowired
	private ScrapDAO scrapDAO;
	
	// 스크랩 클릭시
	public void Scrap(int studyId, Integer userId) {
		boolean existScrap = existScrap(studyId, userId);
		
		if(existScrap) {
			// 스크랩이 클릭 되어 있을 시 delete
			scrapDAO.deleteScrap(studyId, userId);
		} else {
			// 스크랩이 클릭 안되어 있을 시 insert
			scrapDAO.insertScrap(studyId, userId);
		}
	}
	
	
	// 스크랩 클릭 여부 확인
	public boolean existScrap(int studyId, Integer userId) {
		if(userId == null) {
			return false;
		}
		int count = scrapDAO.selectScrapByStudyIdOrUserId(studyId, userId);
		
		if(count > 0) {
			return true;
		}
		
		return false;
	}
	
}
