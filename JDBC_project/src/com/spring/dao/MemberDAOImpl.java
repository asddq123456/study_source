package com.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdbc.source.DataSource;
import com.jdbc.utils.JDBCUtil;
import com.spring.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl instance=new MemberDAOImpl();
	private MemberDAOImpl(){}
	public static MemberDAOImpl getInstance(){
		return instance;
	}
	
	// 1. Connection 얻어오기
	// 2. Statement / PreparedStatement 생성.
	// 3. sql 제작.
	// 4. 2번의 클래스를 이용하여 sql injection..
	// 5. 4번의 결과를 ResultSet 저장..
	// 6. 필요하다면 ResultSet 결과를 VO 객체화 함.

	@Override
	public List<MemberVO> selectMemberList() throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberVO> memberList = null;

		String sql = "select * from member "
					+ "order by member_regdate desc";

		try {
			conn = DataSource.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			// stmt.executeUpdate(sql) : DML 문을 질의.....

			memberList = new ArrayList<MemberVO>();

			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pwd(rs.getString("member_pwd"));
				member.setMember_name(rs.getString("member_name"));
				Date date = new Date(rs.getTimestamp("member_regdate").getTime());

				member.setMember_regDate(date);

				memberList.add(member);
			}
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}

		return memberList;
	}

	@Override
	public MemberVO selectMemberByID(String member_id) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;

		String sql = "select * from member " 
					+ "where member_id=?";

		try {
			conn = DataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new MemberVO();
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pwd(rs.getString("member_pwd"));
				member.setMember_name(rs.getString("member_name"));
				Date date = new Date(rs.getTimestamp("member_regdate").getTime());

				member.setMember_regDate(date);
			}
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into member(member_id,member_pwd," 
					+ "member_name) " + "values(?,?,?)";
		try {
			conn = DataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pwd());
			pstmt.setString(3, member.getMember_name());

			pstmt.executeUpdate();

		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return;
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update member set member_pwd=?, member_name=?," 
					+ "member_regdate=? " + "where member_id=?";
		try {
			conn = DataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMember_pwd());
			pstmt.setString(2, member.getMember_name());

			Timestamp date = new Timestamp(member.getMember_regDate().getTime());
			pstmt.setDate(3, new java.sql.Date(date.getTime()));
			pstmt.setString(4, member.getMember_id());

			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return;
	}

	@Override
	public void deleteMember(String member_id) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from member " 
		+ "where member_id=?";

		try {
			conn = DataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return;
	}

}
