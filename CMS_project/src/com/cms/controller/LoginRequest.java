package com.cms.controller;

public class LoginRequest {
	private String id;
	private String pwd;
	
	public LoginRequest(){}
	public LoginRequest(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "LoginRequest [id=" + id + ", pwd=" + pwd + "]";
	}
	
	
	
	
}
