package com.withstudy.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.withstudy.study.bo.StudyBO;
import com.withstudy.study.model.Study;

@Controller
@RequestMapping("/user/mypage")
public class MypageController {
	
	@Autowired
	private StudyBO studyBO;
	
	// 마이페이지-내정보
	@RequestMapping("/myinfo_view")
	public String mypageUserInfo(Model model) {
		model.addAttribute("viewName", "mypage/myinfo");
		
		return "template/template";
	}
	
	// 마이페이지-내가 쓴 글
	@RequestMapping("/mystudy_view")
	public String mypageUserStudy(Model model,
			HttpSession session) {
		
		Integer userId = (Integer)session.getAttribute("userId");
		
		List<Study> myStudyList = studyBO.getStudyByuserId(userId);
		
		model.addAttribute("viewName", "mypage/mystudy");
		model.addAttribute("myStudyList", myStudyList);
		return "template/template";
	}
}
