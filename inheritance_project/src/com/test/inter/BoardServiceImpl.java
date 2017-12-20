package com.test.inter;

import java.util.List;

public class BoardServiceImpl implements BoardService {

	private static BoardServiceImpl instance=new BoardServiceImpl();
	private BoardServiceImpl(){}
	public static BoardServiceImpl getInstance(){
		return instance;
	}
	
	private BoardDAO boardDao;
	public void setBoardDAO(BoardDAO boardDao){
		this.boardDao=boardDao;
	}
	
	
	@Override
	public void createBoard(Board board) {
		boardDao.insertBoard(board);

	}

	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void removeBoard(String bno) {
		boardDao.deleteBoard(bno);
	}

	@Override
	public Board getBoardByBno(String bno) {
		Board board=boardDao.selectBoardByBno(bno);
		return board;
	}

	@Override
	public List<Board> getBoardList() {
		List<Board> boardList=boardDao.selectBoardList();
		return boardList;
	}

	@Override
	public void createBoardWithFile(Board board) {
		// TODO Auto-generated method stub
		
	}

}
