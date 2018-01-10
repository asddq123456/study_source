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
	
	//ȸ�� ����Ʈ ����
	List<MemberVO> getMemberList() throws SQLException;
	//ȸ�� ���� ����
	MemberVO getMemberByID(String member_id)throws SQLException;
	//ȸ�� �����ϱ�
	void joinMember(JoinRequest req)throws SQLException
										   ,FailToVerifiedIDException;
	//ȸ�� �����ϱ�
	void modifyMember(ModifyRequest req)throws SQLException;
	//ȸ�� Ż���ϱ�
	void removeMember(String member_id)throws SQLException;
	
	//�α��� �ϱ�
	void login(LoginRequest req)
			throws SQLException,NotFoundIDException,InvalidPasswordException; 
	//�α׾ƿ� �ϱ�
	void logout()throws SQLException,NullLoginUserException;
	
	
}







