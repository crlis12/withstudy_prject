package com.withstudy.user.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	// 유저 아이디 중복 확인
	public int selectcheckloginId(String loginId);
}
