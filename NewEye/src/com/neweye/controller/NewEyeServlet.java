package com.neweye.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.action.Action;

@WebServlet("/NewEye")
public class NewEyeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command = request.getParameter("command");
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		if (action != null) {
			action.execute(request, response);
		}else{
			PrintWriter out=response.getWriter();
			out.println("<h1>해당 페이지가 없습니다.</h1>");
			out.println("<a href=\"NewEye?command=index\">메인페이지로 이동</a>");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

