package com.withstudy.join;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.withstudy.join.bo.JoinBO;


@RequestMapping("/join")
@RestController
public class JoinRestController {
	
	@Autowired
	private JoinBO	joinBO;
	
	@RequestMapping("/apply")
	public Map<String, Object> joinApply(
			@RequestParam("studyId") int studyId,
			HttpSession session) {
		
		Integer userId = (Integer)session.getAttribute("userId");
		// 글 방장이랑 로그인 된 아이디 비교 (같으면 신청 불가, 다르면 신청 가능)
		Map<String, Object> result = new HashMap<>();
		
		// insertDB(신청중)
		joinBO.join(userId, studyId);
		result.put("result", "success");
		
		
		return result;
		
	}
}
