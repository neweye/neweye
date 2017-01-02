package com.neweye.admin.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.action.Action;
import com.neweye.dao.MemberDAO;
import com.neweye.dao.iBatis.MemberDAO_iBatis;
import com.neweye.dto.MemberVO;

public class AdminUpdateFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "member/myPageMember.jsp";
		
		String id = request.getParameter("id");
		MemberDAO memberDAO = MemberDAO_iBatis.getInstance();
		
		MemberVO memberVO=null;
		try {
			memberVO = memberDAO.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("memberVO",memberVO);
		
		
		return url;
	}

}
