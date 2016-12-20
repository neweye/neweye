package com.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.db.sqlconfig.IBatisDBConnector;
import com.board.dto.Board;
import com.board.service.BoardService;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ListAction extends Action{

	private BoardService boardService;
	public void setBoardService(BoardService boardService){
		this.boardService=boardService;
	}	
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		String view="list.jsp";
		
		List<Board> boardList=boardService.getBoardList();
		
		request.setAttribute("boardList", boardList);
		
		return view;
	}

}








