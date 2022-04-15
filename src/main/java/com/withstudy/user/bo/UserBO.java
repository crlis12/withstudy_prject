package com.withstudy.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withstudy.user.dao.UserDAO;
import com.withstudy.user.model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	//select 
	
	// 유저 아이디 중복 확인
	public int getcheckloginId(String loginId) {
		
		return userDAO.selectcheckloginId(loginId);
	}
	
	//로그인
	public User getUserSignIn(String loginId, String password) {
		
		return userDAO.selectUserSignIn(loginId, password);
	}

	//insert
	
	// 유저 회원가입
	public int addUser(String loginId, String password, String name, String email, String location) {
		
		return  userDAO.insertUser(loginId, password, name, email, location);
	}
	
	
	
}
