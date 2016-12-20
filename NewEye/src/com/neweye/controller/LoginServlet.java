package com.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.dto.MemberVO;

@WebServlet("/login")
public class LoginServlet extends MemberServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "loginForm.jsp";
		ViewResolver.goURI(url, request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String url = "redirect:memberList";
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		int result = -1;
		String message="";
		
		try {
			result = memberService.loginMember(userid, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		switch (result) {
		case 0:
			message="아이디가 존재하지 않습니다.";
			url="redirect:login";
			session.setAttribute("userid", userid);
			break;
		case -1:
			message="패스워드가 일치하지 않습니다.";
			url="redirect:login";
			session.setAttribute("userid", userid);
			break;
		case 1:
			MemberVO member=null;
			try {
				member = memberService.getMember(userid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("loginUser", member);
			break;
		default:;

		}
		
		session.setAttribute("message", message);

		ViewResolver.goURI(url, request, response);
	}

}
