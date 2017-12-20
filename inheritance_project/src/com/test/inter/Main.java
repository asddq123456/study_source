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
		board.setTitle("결합도 낮추기");
		board.setContent("인스턴스 외부주입");
		
		main.boardService.createBoard(board);

	}

}
