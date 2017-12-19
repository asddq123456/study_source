package com.test.inter;

import java.util.List;

public interface BoardService {
	
	void createBoard(Board board);
	void createBoardWithFile(Board board);
	void modifyBoard(Board board);
	void removeBoard(String bno);
	Board getBoardByBno(String bno);
	List<Board> getBoardList();
	
}







