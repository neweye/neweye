package com.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dto.MemberVO;

@WebServlet("/update")
public class UpdateMemberServlet extends MemberServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="updateForm.jsp";
		
		String userid=request.getParameter("userid");
		
		try {
			MemberVO member = memberService.getMember(userid);
			request.setAttribute("member", member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ViewResolver.goURI(url, request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String url="redirect:memberList";
		
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		MemberVO member=new MemberVO(name, userid, password, email);
		
		try {
			memberService.updateMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ViewResolver.goURI(url, request, response);
		
	}

}
