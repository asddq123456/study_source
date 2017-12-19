package com.test.inter;

import java.util.Date;

public class Board {
	//�۹�ȣ
	private int bno;
	
	//������
	private String title;
	
	//����ȸ��
	private int viewcnt;
	
	//�ۼ���¥
	private Date indate;
	
	//����
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











