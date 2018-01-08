package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.exception.FailToVerifiedIDException;
import com.jdbc.exception.InvalidPasswordException;
import com.jdbc.exception.NotFoundIDException;
import com.jdbc.exception.NullLoginUserException;
import com.jdbc.scope.SessionScope;
import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;
import com.spring.view.JoinRequest;
import com.spring.view.LoginRequest;
import com.spring.view.ModifyRequest;

public class MemberServiceImpl implements MemberService {
	
	private static MemberServiceImpl instance=new MemberServiceImpl();
	private MemberServiceImpl(){}
	public static MemberServiceImpl getInstance(){
		return instance;
	}
	
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO){
		this.memberDAO=memberDAO;
	}
	
	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList=memberDAO.selectMemberList();
		return memberList;
	}

	@Override
	public MemberVO getMemberByID(String member_id) throws SQLException {
		MemberVO member=memberDAO.selectMemberByID(member_id);
		return member;
	}

	@Override
	public void joinMember(JoinRequest req) 
					throws SQLException,FailToVerifiedIDException {
		
		MemberVO member
			=memberDAO.selectMemberByID(req.getMember_id());
		if(member!=null){//아이디 중복
			throw new FailToVerifiedIDException();
		}
		
		member=req.toMemberVO();
		
		memberDAO.insertMember(member);

	}

	@Override
	public void modifyMember(ModifyRequest req) throws SQLException {
		MemberVO member=req.toMemberVO();
		memberDAO.updateMember(member);
	}

	@Override
	public void removeMember(String member_id) throws SQLException {
		memberDAO.deleteMember(member_id);
	}

	@Override
	public void login(LoginRequest req) throws SQLException, NotFoundIDException, InvalidPasswordException {
		MemberVO member=memberDAO.selectMemberByID(req.getId());
		if(member!=null){//아이디 존재
			if(req.getPwd().equals(member.getMember_pwd())){//로그인확인.
				SessionScope.loginUser=member; //로그인 상태유지
				return;
			}else{
				throw new InvalidPasswordException();
			}
		}else{// 아이디 불일치
			throw new NotFoundIDException();
		}
	}

	@Override
	public void logout() throws SQLException,NullLoginUserException {
		if(SessionScope.loginUser!=null){
			SessionScope.loginUser=null;
		}else{
			throw new NullLoginUserException();
		}
	}

}






