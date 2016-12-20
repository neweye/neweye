package com.neweye.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.service.BoardService;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.neweye.action.Action;
import com.neweye.db.sqlconfig.IBatisDBConnector;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map actionMap = new HashMap();
	
	private BoardService boardService;

	@Override
	public void init() throws ServletException {		
		loadProperties("com/board/properties/Command");	
		
		SqlMapClient client=IBatisDBConnector.getSqlMapInstance();
		
		BoardDao boardDao=BoardDao.getInstance();
		boardDao.setClient(client);
		
		boardService=BoardService.getInstance();
		boardService.setBoardDao(boardDao);
	}

	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path);

		Enumeration<String> actionEnumHome = rbHome.getKeys();
		while (actionEnumHome.hasMoreElements()) {
			String command = actionEnumHome.nextElement();
			String actionName = rbHome.getString(command);
			try {
				Class actionClass = Class.forName(actionName);
				Object actionInstance = actionClass.newInstance();

				actionMap.put(command, actionInstance);

			} catch (ClassNotFoundException e) {
				continue;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	private void requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String view = null;
		Action action = null;

		try {
			String command = request.getRequestURI();
			if (command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}

			action = (Action) actionMap.get(command);

			if (action == null) {
				System.out.println("not found : " + command);
				return;
			}

			view = action.execute(request, response);
		} catch (Throwable e) {
			throw new ServletException(e);
		}

		if (view == null) {
			return;
		}
		
		ViewResolver.goURI(view, request, response);
		
	}
}









