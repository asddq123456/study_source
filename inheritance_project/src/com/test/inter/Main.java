package com.test.inter;

import com.test.singletone.DataSource;

public class Main {
	
	BoardService boardService;
	
	{
		DataSource db=DataSource.getInstance();
		BoardDAO boardDao=BoardDAOImpl.getInstance();
		boardService=BoardServiceImpl.getInstance();
		
		((BoardDAOImpl)boardDao).setDataSource(db);
		((BoardServiceImpl)boardService).setBoardDAO(boardDao);
		
	}

	public static void main(String[] args) {		
		
		Main main=new Main();
		
		
		Board board=new Board();
		board.setTitle("ÀÏºü");
		board.setContent("³Ã¹«");
		
		main.boardService.createBoard(board);

	}

}
