package com.withstudy.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.withstudy.user.model.User;

@Repository
public interface UserDAO {

	// 유저 아이디 중복 확인
	public int selectcheckloginId(String loginId);
	
	//유저 고유번호
	public User selectUserByuserId(int userId);
	
	// 로그인
	public User selectUserSignIn(
			@Param("loginId") String loginId,
			@Param("password") String password);
	
	// 회원가입
	public int insertUser(
			@Param("loginId") String loginId,
			@Param("password") String password,
			@Param("name") String name,
			@Param("email") String email,
			@Param("location") String location);
	
	//비밀번호 변경
	public int upadateUser(
			@Param("loginId") String loginId,
			@Param("password") String password);
}
