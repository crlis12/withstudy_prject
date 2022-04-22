package com.withstudy.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.withstudy.common.EncryptUtils;
import com.withstudy.user.bo.UserBO;
import com.withstudy.user.model.User;


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
	/**
	 * 회원가입
	 * @param loginId
	 * @param password
	 * @param name
	 * @param email
	 * @param location
	 * @return
	 */
	@RequestMapping("/sign_up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("location") String location) {
		
		Map<String, Object> result = new HashMap<>();
		
		String encryptUtilsPassword = EncryptUtils.md5(password);
		//insert DB
		int row = userBO.addUser(loginId, encryptUtilsPassword, name, email, location);
		
		if(row == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
			result.put("errorMessage", "회원가입에 실패하였습니다. 다시 입력해주세요");
		}
		
		
		return result;
	}
	
	/**
	 * 로그인
	 * @param loginId
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/sign_in")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpSession session) {
		
		String encryptUtilsPassword = EncryptUtils.md5(password);
		
		Map<String, Object> result = new HashMap<>();
		
		// select DB
		User user = userBO.getUserSignIn(loginId, encryptUtilsPassword);
		
		if(user != null) {
			result.put("result", "success");
			
			//유저 정보 저장
			session.setAttribute("userloginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userId", user.getId());
		} else {
			result.put("result", "error");
			result.put("errorMessage", "없는 사용자입니다");
		}
		
		return result;
	}
	
	
	
}
