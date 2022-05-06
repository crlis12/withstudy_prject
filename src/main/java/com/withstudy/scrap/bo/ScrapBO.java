package com.withstudy.scrap.bo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.Session;
import com.withstudy.scrap.dao.ScrapDAO;
import com.withstudy.scrap.model.Scrap;
import com.withstudy.scrap.model.ScrapView;
import com.withstudy.study.bo.StudyBO;
import com.withstudy.study.model.Study;

@Service
public class ScrapBO {
	
	@Autowired
	private ScrapDAO scrapDAO;
	
	@Autowired
	private StudyBO studyBO;
	
	// 스크랩 조회
	public List<Scrap> getScrapList(Integer userId) {
		
		return scrapDAO.selectScrapByStudyId(userId);
	}
	
	
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
	
	// 스크랩 콘텐츠 가져오기
	public List<ScrapView> getScrapView(Integer userId) {
		
		List<ScrapView> resultList = new ArrayList<>();
		List<Scrap> scrapList = getScrapList(userId);
		
		for(Scrap scrap : scrapList) {
			ScrapView scrapView = new ScrapView();
			
			scrapView.setScrap(scrap);
			
			resultList.add(scrapView);
		}
		return resultList;
	}
	
}
