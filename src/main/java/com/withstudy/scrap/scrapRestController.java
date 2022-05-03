package com.withstudy.scrap;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.withstudy.scrap.bo.ScrapBO;

@RequestMapping("/scrap")
@RestController
public class ScrapRestController {
	
	@Autowired
	private ScrapBO scrapBO;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("{studyId}")
	public Map<String, Object> scrap(
			@PathVariable int studyId,
			HttpSession session) {
		
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// 로그인이 안되어 있을 시
		if (userId == null) {
			result.put("result", "error");
			result.put("error_message", "로그인을 해주세요.");
			logger.error("[스크랩] 로그인 세션이 없습니다.");
			return result;
		}
		
		// insertDB boolean
		scrapBO.Scrap(studyId, userId);
		result.put("result", "success");
		return result;
	}
}
