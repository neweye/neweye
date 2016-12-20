package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.db.sqlconfig.IBatisDBConnector;
import com.board.service.BoardService;
import com.ibatis.sqlmap.client.SqlMapClient;


public abstract class Action {	
	
	private BoardService boardService;
	
	
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response) 
			throws Throwable;
}










