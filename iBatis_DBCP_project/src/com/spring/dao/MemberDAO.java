package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.MemberVO;

public interface MemberDAO {
	
	// 회원관리 ...............
	
	//회원 리스트
	List<MemberVO> selectMemberList() throws SQLException;
	
	//회원 정보
	MemberVO selectMemberByID(String member_id) throws SQLException;
	
	//회원 등록
	void insertMember(MemberVO member) throws SQLException;
	
	//회원 수정
	void updateMember(MemberVO member) throws SQLException;
	
	//회원 삭제
	void deleteMember(String member_id)throws SQLException;
	
}








