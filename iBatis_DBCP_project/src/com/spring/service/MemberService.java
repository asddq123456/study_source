package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.exception.FailToVerifiedIDException;
import com.jdbc.exception.InvalidPasswordException;
import com.jdbc.exception.NotFoundIDException;
import com.jdbc.exception.NullLoginUserException;
import com.spring.dto.MemberVO;
import com.spring.view.JoinRequest;
import com.spring.view.LoginRequest;
import com.spring.view.ModifyRequest;

public interface MemberService {
	
	//회원 리스트 보기
	List<MemberVO> getMemberList() throws SQLException;
	//회원 정보 보기
	MemberVO getMemberByID(String member_id)throws SQLException;
	//회원 가입하기
	void joinMember(JoinRequest req)throws SQLException
										   ,FailToVerifiedIDException;
	//회원 수정하기
	void modifyMember(ModifyRequest req)throws SQLException;
	//회원 탈퇴하기
	void removeMember(String member_id)throws SQLException;
	
	//로그인 하기
	void login(LoginRequest req)
			throws SQLException,NotFoundIDException,InvalidPasswordException; 
	//로그아웃 하기
	void logout()throws SQLException,NullLoginUserException;
	
	
}







