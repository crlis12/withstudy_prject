package com.withstudy.study;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.withstudy.comment.bo.CommentBO;
import com.withstudy.comment.model.Comment;
import com.withstudy.study.bo.StudyBO;
import com.withstudy.study.model.Study;

@RequestMapping("study")
@Controller
public class StudyController {
	
	@Autowired
	private StudyBO studyBO;
	
	@Autowired
	private CommentBO commentBO;
	
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
	
	@RequestMapping("study_detail_view")
	public String detailStudy(Model model,
			@RequestParam("studyId") int studyId)	{
		
		// 로그인 되었을때만 글 확인
		
		// select DB(해당 글 확인)
		Study study = studyBO.getStudyById(studyId);
		
		// 댓글 내용 가지고 오기
		List<Comment> comment = commentBO.getcommentListByStudyId(studyId);
		
		
		model.addAttribute("viewName", "study/study_detail");
		model.addAttribute("study", study);
		model.addAttribute("commentList", comment);
		return "template/template";
	}
}
