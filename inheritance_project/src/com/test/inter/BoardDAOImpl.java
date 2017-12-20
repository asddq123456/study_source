package com.test.inter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.test.singletone.DataSource;

public class BoardDAOImpl implements BoardDAO {
	
	private static BoardDAOImpl instance=new BoardDAOImpl();
	private BoardDAOImpl(){}
	public static BoardDAOImpl getInstance(){
		return instance;
	}
	
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource){
		this.dataSource=dataSource;
	}
	
	@Override
	public void insertBoard(Board board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into board(bno,title,content)"
				+ "values(board_seq.nextval,?,?)";
		
		con=dataSource.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());			
			pstmt.setString(2, board.getContent());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(String bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public Board selectBoardByBno(String bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> selectBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

}
