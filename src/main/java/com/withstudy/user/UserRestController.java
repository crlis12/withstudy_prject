package com.withstudy.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.withstudy.user.bo.UserBO;


@RequestMapping("/user")
@RestController
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	/**
	 * 아이디 중복확인
	 * @param loginId
	 * @return
	 */
	@RequestMapping("/idCheck")
	public Map<String, Object> idCheck(
			@RequestParam("loginId") String loginId) {
		Map<String, Object> result = new HashMap<>();
		
		// DB
		int checkloginId = userBO.getcheckloginId(loginId);
		
		if(checkloginId > 0) {
			result.put("result", true);
		} else {
			result.put("result", false);
		}
		
		
		return result;
	}
	@RequestMapping("/sign_up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("location") String location) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		//insert DB
		
		
		return result;
	}
}
