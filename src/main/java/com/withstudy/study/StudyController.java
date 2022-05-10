package com.withstudy.study;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.withstudy.comment.bo.CommentBO;
import com.withstudy.comment.model.CommentView;
import com.withstudy.join.bo.JoinBO;
import com.withstudy.join.model.Join;
import com.withstudy.scrap.bo.ScrapBO;
import com.withstudy.study.bo.StudyBO;
import com.withstudy.study.model.Study;

@RequestMapping("study")
@Controller
public class StudyController {
	
	@Autowired
	private StudyBO studyBO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private ScrapBO scrapBO;
	
	@Autowired
	private JoinBO joinBO;
	
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
			@RequestParam("studyId") int studyId,
			HttpSession session)	{
		
		Integer userId = (Integer)session.getAttribute("userId");
		// 로그인 되었을때만 글 확인
		
		// select DB(해당 글 확인)
		Study study = studyBO.getStudyById(studyId);
		
		// 댓글 내용 가지고 오기
		List<CommentView> commentViewList = commentBO.getCommentViewList(studyId);
		
		boolean scrapCheck = scrapBO.existScrap(studyId, userId);
		boolean joinCheck = joinBO.existJoin(userId, studyId);
		int joinCount = joinBO.getJoinByStudyId(studyId);
		Join joinUser = joinBO.getJoinUser(userId, studyId);
		
		model.addAttribute("viewName", "study/study_detail");
		model.addAttribute("study", study);
		model.addAttribute("commentViewList", commentViewList);
		model.addAttribute("scrapCheck", scrapCheck);
		model.addAttribute("joinCheck", joinCheck);
		model.addAttribute("joinCount", joinCount);
		model.addAttribute("joinUser", joinUser);
		
		return "template/template";
	}
}
