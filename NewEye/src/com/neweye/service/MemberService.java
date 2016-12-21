package com.neweye.service;

import java.sql.SQLException;
import java.util.List;

import com.board.dao.BoardDao;
import com.board.dto.Board;
import com.neweye.dao.MemberDAOImpl;

public class MemberService {

	private static MemberService instance=new MemberService();
	private MemberService(){}
	public static MemberService getInstance(){
		return instance;
	}
	
	private MemberDAOImpl boardDao;
	public void setBoardDao(BoardDao boardDao){
		this.boardDao=boardDao;
	}
	public List<Board> getBoardList() throws SQLException{
		return boardDao.selectAllBoard(); 
	}
}














