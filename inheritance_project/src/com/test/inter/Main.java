package com.test.inter;

public class Main {

	public static void main(String[] args) {
		
		BoardService service=new BoardServiceImpl();
		
		Board board=new Board();
		board.setTitle("�Ϻ�");
		board.setContent("�ù�");
		
		service.createBoard(board);

	}

}
