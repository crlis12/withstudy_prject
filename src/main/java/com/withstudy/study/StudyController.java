package com.withstudy.study;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.withstudy.study.bo.StudyBO;
import com.withstudy.study.model.Study;

@RequestMapping("study")
@Controller
public class StudyController {
	
	@Autowired
	private StudyBO studyBO;
	
	@RequestMapping("study_view")
	public String studyView(Model model) {
		
		List<Study> studyList = studyBO.getStudyList();
		model.addAttribute("viewName", "study/study");
		model.addAttribute("studyList", studyList);
		
		return "template/template";
	}
	
	@RequestMapping("study_create_view")
	public String addStudy(Model model) {
		model.addAttribute("viewName", "study/study_create");
		return "template/template";
	}
}
