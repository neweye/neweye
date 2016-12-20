package com.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dto.MemberVO;

@WebServlet("/detailMember")
public class DetailMemberServlet extends MemberServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="detailMember.jsp";
		
		String userid=request.getParameter("userid");
		
		try {
			MemberVO member=memberService.getMember(userid);
			request.setAttribute("member", member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ViewResolver.goURI(url, request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
