package com.neweye.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.neweye.dao.MemberDAO;
import com.neweye.dao.MemberDAOImpl;
import com.neweye.jdbc.DataSource;
import com.neweye.jdbc.loader.DBCPInit;
import com.test.service.MemberService;
import com.test.service.MemberServiceImpl;


public class MemberServlet extends HttpServlet {
	protected MemberService memberService;
	public void setMemberService(MemberService memberService){
		this.memberService=memberService;
	}	
	
	@Override
	public void init() throws ServletException {
		DataSource db=DBCPInit.getInstance();
		
		MemberDAO memberDAO=MemberDAOImpl.getInstance();
		((MemberDAOImpl)memberDAO).setDatasource(db);
		
		MemberService memberService=MemberServiceImpl.getInstance();
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
		
		this.setMemberService(memberService);		
		
	}
}
