package com.neweye.dao;

import java.sql.SQLException;
import java.util.List;

import com.board.dto.Board;
import com.ibatis.sqlmap.client.SqlMapClient;

public class BoardDao{
	private static BoardDao instance=new BoardDao();
	private BoardDao(){}
	public static BoardDao getInstance(){
		return instance;
	}
	
	private SqlMapClient client;
	
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	public List<Board> selectAllBoard() throws SQLException{
		List<Board> boardList=(List<Board>)client.queryForList("selectAllBoard",null);
		return boardList;
	}
	
	public Board selectBoard(int boardNum) throws SQLException{
		Board board=(Board)client.queryForObject("selectBoard", boardNum);		
		return board;		
	}
	
	public int insertBoard(Board board) throws SQLException{
		int result = client.update("insertBoard",board);
		return result;
	}
	
	public int updateBoard(Board board) throws SQLException{
		int result=client.update("updateBoard",board);
		return result;				
	}
	public int deleteBoard(int boardNum) throws SQLException{
		int result=client.update("deleteBoard",boardNum);
		return result;
	}
}









