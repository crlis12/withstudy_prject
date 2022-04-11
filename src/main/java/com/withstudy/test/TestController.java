package com.withstudy.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@ResponseBody
	@RequestMapping("/test1")
	public String test1() {
		
		return "Hello world!";
	}
	
	
	@RequestMapping("/test2")
	public String test2() {
		
		return "test/test1";
	}
	
	@ResponseBody
	@RequestMapping("/test3")
	public Map<String, Object> test3() {
		Map<String, Object> result = new HashMap<>();
		result.put("aa", 1234);
		result.put("bb", 12345);
		result.put("cc", 12346);
		result.put("dd", 12347);
		
		return result;
	}
	
}
