package com.spring.view;

import java.util.Date;

import com.spring.dto.MemberVO;

public class JoinRequest {
	
	private String member_id;
	private String member_pwd;
	private String member_name;

	
	public JoinRequest(){};
	
	public JoinRequest(String member_id, String member_pwd, String member_name) {
		super();
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	@Override
	public String toString() {
		return "MemberVO [member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name=" + member_name
				+ ", member_regDate=" +  "]";
	}
	
	public MemberVO toMemberVO(){
		MemberVO member=new MemberVO();
		member.setMember_name(member_name);
		member.setMember_pwd(member_pwd);
		member.setMember_id(member_id);
		return member;
	} 
	
	
}











