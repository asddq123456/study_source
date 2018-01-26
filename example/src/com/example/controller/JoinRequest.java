package com.example.controller;

public class JoinRequest {
	private String memNm;
	private String memId;
	private String memPwd;
	private String email;
	private String entCmmnClf;
	private String prtblTlphnNo;
	private String smsRcvAgree;
	private String emailRcvAgree;
	
	
	public JoinRequest(){}
	public JoinRequest(String memNm, String memId, String memPwd, String email, String entCmmnClf, String prtblTlphnNo,
			String smsRcvAgree, String emailRcvAgree) {
		super();
		this.memNm = memNm;
		this.memId = memId;
		this.memPwd = memPwd;
		this.email = email;
		this.entCmmnClf = entCmmnClf;
		this.prtblTlphnNo = prtblTlphnNo;
		this.smsRcvAgree = smsRcvAgree;
		this.emailRcvAgree = emailRcvAgree;
	}
	public String getMemNm() {
		return memNm;
	}
	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPwd() {
		return memPwd;
	}
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEntCmmnClf() {
		return entCmmnClf;
	}
	public void setEntCmmnClf(String entCmmnClf) {
		this.entCmmnClf = entCmmnClf;
	}
	public String getPrtblTlphnNo() {
		return prtblTlphnNo;
	}
	public void setPrtblTlphnNo(String prtblTlphnNo) {
		this.prtblTlphnNo = prtblTlphnNo;
	}
	public String getSmsRcvAgree() {
		return smsRcvAgree;
	}
	public void setSmsRcvAgree(String smsRcvAgree) {
		this.smsRcvAgree = smsRcvAgree;
	}
	public String getEmailRcvAgree() {
		return emailRcvAgree;
	}
	public void setEmailRcvAgree(String emailRcvAgree) {
		this.emailRcvAgree = emailRcvAgree;
	}
	
	
}
