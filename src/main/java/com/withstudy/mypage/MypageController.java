package com.withstudy.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/mypage")
public class MypageController {
	
		// 마이페이지-내정보
		@RequestMapping("/myinfo_view")
		public String mypageUserInfo(Model model) {
			model.addAttribute("viewName", "mypage/myinfo");
			
			return "template/template";
		}
}
