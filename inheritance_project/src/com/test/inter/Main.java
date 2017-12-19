package com.test.inter;

public class Main {

	public static void main(String[] args) {
		
		BoardService service=new BoardServiceImpl();
		
		Board board=new Board();
		board.setTitle("ÀÏºü");
		board.setContent("³Ã¹«");
		
		service.createBoard(board);

	}

}
