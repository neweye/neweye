package com.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.MemberDAO;
import com.neweye.dao.MemberDAOImpl;
import com.neweye.dto.MemberVO;
import com.neweye.jdbc.DataSource;
import com.test.service.MemberService;
import com.test.service.MemberServiceImpl;


@WebServlet("/memberList")
public class MemberListServlet extends MemberServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="viewMember.jsp";
		List<MemberVO> memberList=null;
		
		try {
			memberList=memberService.getMemberList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("memberList", memberList);
		
		ViewResolver.goURI(url, request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
