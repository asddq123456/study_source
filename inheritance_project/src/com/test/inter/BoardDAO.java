package com.test.inter;

import java.util.List;

public interface BoardDAO {

	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(String bno);
	Board selectBoardByBno(String bno);
	List<Board> selectBoardList();
}
