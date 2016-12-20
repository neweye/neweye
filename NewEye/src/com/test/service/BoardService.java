package com.test.service;

import java.sql.SQLException;
import java.util.List;

import com.board.dao.BoardDao;
import com.board.dto.Board;

public class BoardService {

	private static BoardService instance=new BoardService();
	private BoardService(){}
	public static BoardService getInstance(){
		return instance;
	}
	
	private BoardDao boardDao;
	public void setBoardDao(BoardDao boardDao){
		this.boardDao=boardDao;
	}
	public List<Board> getBoardList() throws SQLException{
		return boardDao.selectAllBoard(); 
	}
}














