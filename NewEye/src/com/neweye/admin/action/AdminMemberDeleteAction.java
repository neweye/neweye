package com.neweye.admin.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.action.Action;
import com.neweye.dao.MemberDAO;
import com.neweye.dao.iBatis.MemberDAO_iBatis;
import com.neweye.dto.MemberVO;

public class AdminMemberDeleteAction implements Action{
/*
	@Override
	public String admindeleteuseMember(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "adminMemberList.ne";
		

		String id = request.getParameter("id");
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setUseyn("n");

		MemberDAO memberDAO = MemberDAO_iBatis.getInstance();
		try {
			memberDAO.deleteuseMember(member);
			HttpSession session = request.getSession();
			session.invalidate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}
*/
}
