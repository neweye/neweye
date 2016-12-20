package com.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dto.MemberVO;


@WebServlet("/joinMember")
public class InsertMemberServlet extends MemberServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="joinForm.jsp";
		ViewResolver.goURI(url, request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String url="redirect:memberList";
		
		MemberVO member=new MemberVO();
		
		member.setEmail(request.getParameter("email"));
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setUserid(request.getParameter("userid"));
		
		try {
			memberService.insertMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ViewResolver.goURI(url, request, response);
	}

}




