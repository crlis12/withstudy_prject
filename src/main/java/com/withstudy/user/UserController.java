package com.withstudy.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
	
	
	
	// 회원가입 화면
	@RequestMapping("/sign_up_view")
	public String userSignUp(Model model) {
		
		model.addAttribute("viewName", "user/sign_up");
		
		return "template/template";
	}
	
	// 로그인 화면
	@RequestMapping("/sign_in_view")
	public String userSignIn(Model model) {
	
	
		return "user/sign_in";
	}
	
	@RequestMapping("/sign_out")
	public String signOut(
			HttpSession session ) {

		// 세션에 있는 유저 정보 삭제
		session.removeAttribute("userloginId");
		session.removeAttribute("userName");
		session.removeAttribute("userId");
		session.removeAttribute("userEmail");
		
		return "redirect:/user/sign_in_view";
	}
	
	//마이 페이지
	@RequestMapping("/mypage_view")
	public String mypageView(Model model) {
		model.addAttribute("viewName", "user/mypage");
		
		return "template/template";
		
	}
	
	
	
}
