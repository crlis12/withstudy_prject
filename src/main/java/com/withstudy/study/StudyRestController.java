package com.withstudy.study;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.withstudy.study.bo.StudyBO;

@RequestMapping("study")
@RestController
public class StudyRestController {

	@Autowired
	private StudyBO studyBO;
	
	@RequestMapping("/study_create")
	public Map<String, Object> studyCreate(
			@RequestParam("title") String title,
			@RequestParam("personnel") int personnel,
			@RequestParam("deadline") String deadline,
			@RequestParam("location") String location,
			@RequestParam(value = "content", required = false) String content,
			HttpSession session) {
		
		Map<String, Object> result = new HashMap<>();
		//로그인 된 유저 아이디 가져오기(방장 권한)
		int userId	= (int)session.getAttribute("userId");
		int hostuserId = (int)session.getAttribute("userId");
		
		//insert DB
		int row = studyBO.addStudy(userId, hostuserId, title, personnel, deadline, location, content);
		
		if(row == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
			result.put("errorMessage","스터디 모임 생성에 실패했습니다. 다시 작성해주세요");
		}
		return result;
	}
}
