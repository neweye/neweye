package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.MemberDAO;
import com.neweye.dao.iBatis.MemberDAO_iBatis;
import com.neweye.dto.MemberVO;

public class FindIdAction implements Action{

	/*@Override
	public String findId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "/member/findIdForm.jsp";
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		MemberDAO memberDAO=MemberDAO_iBatis.getInstance();
		MemberVO member=null;
		try {
			member = (MemberVO)memberDAO.searchId(name, phone);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("member", member);
		return url;
	}*/

}
