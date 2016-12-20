package com.neweye.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends MemberServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String url="redirect:memberList";
		String message="";
		
		HttpSession session = request.getSession();
		if (memberService.logoutMember(session)) {			
			message="<script>alert('로그아웃 되었습니다.');</script>";
		} else {
			message="<script>alert('로그아웃을 실패했습니다.');</script>";
		}		
		
		session =request.getSession();
		session.setAttribute("message", message);
		
		ViewResolver.goURI(url, request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
