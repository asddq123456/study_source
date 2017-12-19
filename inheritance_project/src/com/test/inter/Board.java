package com.test.inter;

import java.util.Date;

public class Board {
	//글번호
	private int bno;
	
	//글제목
	private String title;
	
	//글조회수
	private int viewcnt;
	
	//작성날짜
	private Date indate;
	
	//내용
	private String content;

	public Board(){}
	public Board(int bno, String title, int viewcnt, Date indate, String content) {
		super();
		this.bno = bno;
		this.title = title;
		this.viewcnt = viewcnt;
		this.indate = indate;
		this.content = content;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", viewcnt=" + viewcnt + ", indate=" + indate + ", content="
				+ content + "]";
	}
	
	
	
}











