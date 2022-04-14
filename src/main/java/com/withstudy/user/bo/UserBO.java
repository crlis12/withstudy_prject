package com.withstudy.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.withstudy.user.dao.UserDAO;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	// 유저 아이디 중복 확인
	public int getcheckloginId(String loginId) {
		
		return userDAO.selectcheckloginId(loginId);
	}
	
	// 유저 회원가입
	public int addUser(String loginId, String password, String name, String email, String location) {
		
		return  userDAO.insertUser(loginId, password, name, email, location);
	}
}
