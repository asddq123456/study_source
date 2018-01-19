package com.cms.dao;

import java.sql.SQLException;
import java.util.List;

import com.cms.dto.MemberVO;

public interface MemberDAO {
	
	// ȸ������ ...............
	
	//ȸ�� ����Ʈ
	List<MemberVO> selectMemberList() throws SQLException;
	
	//ȸ�� ����
	MemberVO selectMemberByID(String member_id) throws SQLException;
	
	//ȸ�� ���
	void insertMember(MemberVO member) throws SQLException;
	
	//ȸ�� ����
	void updateMember(MemberVO member) throws SQLException;
	
	//ȸ�� ����
	void deleteMember(String member_id)throws SQLException;
	
}








