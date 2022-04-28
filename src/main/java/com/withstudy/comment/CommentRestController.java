package com.withstudy.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.withstudy.comment.bo.CommentBO;

@RequestMapping("/comment")
@Controller
public class CommentRestController {
	
	@Autowired
	private CommentBO commentBO; 

	@RequestMapping("/create")
	public Map<String, Object> usercomment(
			@RequestParam("studyId") int studyId,
			@RequestParam("content") String content,
			HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		Integer userId = (Integer)session.getAttribute("userId");
		
		// 로그인이 안되어 있을 시
		if (userId == null) {
			result.put("result", "error");
			result.put("error_message", "로그인을 해주세요.");
			return result;
		}
		//insert DB (로그인 된 아이디,글번호,글 내용)
		int comment = commentBO.addComment(userId, studyId, content);
		
		if(comment  > 0 ) {
			result.put("result", "success");
		}
		return result;
	}
}
