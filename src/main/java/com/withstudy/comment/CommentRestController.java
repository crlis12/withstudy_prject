package com.withstudy.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.withstudy.comment.bo.CommentBO;

@RequestMapping("/comment")
@RestController
public class CommentRestController {
	
	@Autowired
	private CommentBO commentBO; 

	@RequestMapping("/create")
	public Map<String, Object> usercomment(
			@RequestParam("studyId") int studyId,
			@RequestParam("content") String content,
			HttpSession session) {
		
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// 로그인이 안되어 있을 시
		if (userId == null) {
			result.put("result", "error");
			result.put("errorMessage", "로그인을 해주세요.");
			return result;
		}
		
		//insert DB (로그인 된 아이디,글번호,글 내용)
		int row = commentBO.addComment(userId, studyId, content);
		
		if(row > 0) {
			result.put("result", "success");
		} else {
			result.put("errorMessage", "댓글을 다시 작성해 주세요.");
		}
		
		return result;
	}
}
